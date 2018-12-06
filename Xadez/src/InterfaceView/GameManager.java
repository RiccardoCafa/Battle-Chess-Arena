package InterfaceView;

import businessPack.Block;
import businessPack.TypeClicks.ClickOnBlock;
import businessPack.TypeClicks.SpecialClick;
import businessPack.TypeClicks.FirstClick;
import businessPack.Heros.Huebr;
import businessPack.Heros.Lapa;
import businessPack.Heros.Wizard;
import businessPack.Heros.Lenin;
import businessPack.TypeClicks.HitClick;
import businessPack.TypeClicks.LastClick;
import businessPack.TypeClicks.MoveClick;
import businessPack.TypeClicks.MoveSpecialClick;
import businessPack.Piece;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeClicks.ReactionClick;
import businessPack.TypeClicks.TypeClick;
import businessPack.TypeClicks.WizardClick;
import businessPack.TypeHero;
import static businessPack.TypeHero.lenin;
import extras.Vetor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class GameManager {
    //atributos>>
    ClickOnBlock clickOnBlock;
    TypeClick tpClick;
    
    // Vetores auxiliares
    Vetor myVector;
    Vetor selectedVetor;
    
    // Lista de posíveis movimentações e hits
    private ArrayList<Block> possibleBlocks;
    private ArrayList<Block> possibleHits;
    
    // Booleanas para controle
    private boolean movingPiece = false;
    private boolean superPower = false;
    private boolean combo = false;
    private boolean clickSequence;
    
    // System & More
    private String gameName = "System";
    private float volumeSound;
    
    // Game Variables
    private Table table;
    private Player player1;
    private Player player2;
    private Player playing;
    private Lenin estacao;
    private Wizard wiz;
    public static GameCtrl gameCtrl;
    
    private Block click1;
    private Block click2;
    private Block sheriffBlock;
    //construtor>>
    public GameManager(Player p1, Player p2, GameCtrl gameCtrl) {
        this.player1 = p1;
        this.player2 = p2;
        this.gameCtrl = gameCtrl;
        Players.setPlayer1(player1);
        Players.setPlayer2(player2);
        playing = player1;
        table = new Table(8, 8, player1, player2);
        tpClick = TypeClick.first;
        table.setGameCtrl(gameCtrl);

        if(player1.getHero() instanceof Wizard || player2.getHero() instanceof Wizard) {
            Wizard wiz = (Wizard) (player1.getHero() instanceof Wizard ? player1.getHero() : player2.getHero());
            for(int i = 0; i < 8; i ++) {
                gameCtrl.pratoPieces.getChildren().add(wiz.getWallImage(i));
            }
        }

        getOptionsInfo();

    }
    //metodos>>
    public void GameInit() {
        table.initTable(player1, player2);
        if(player1.getHero().getHeroType() == TypeHero.lenin){
            estacao = (Lenin) player1.getHero();
            showSeasons(estacao.getEstacao());
        }
        if(player2.getHero().getHeroType() == TypeHero.lenin){
            estacao = (Lenin) player2.getHero();
            showSeasons(estacao.getEstacao());
        }     
        
        if(Players.getActualPlayer().getHero().getHeroType() == TypeHero.wizard){
            wiz = (Wizard) Players.getActualPlayer().getHero();
        }else if (Players.getAdversaryPlayer().getHero().getHeroType() == TypeHero.wizard){
            wiz =  (Wizard) Players.getAdversaryPlayer().getHero();     
        }
    }
    public void getOptionsInfo() {
        
    }
    public void clearHighlight(){
        for(int i = 0; i < Table.getN(); i++){
            for(int j = 0; j < Table.getM(); j++){
                table.getBlock(i, j).colorDefault();
            }
        }
    }
    public TypeClick showMoves(Block actualBlock){
        actualBlock.getPiece().checkMove(table);
        possibleBlocks = actualBlock.getPiece().getFreeWay();
        if(possibleBlocks == null || possibleBlocks.isEmpty()){//se o freeWay for vazio ou nulo, saia do evento
            GameManager.this.setClickSequence(false);
            click1 = null;
            return TypeClick.first;
        }else{
            possibleHits = actualBlock.getPiece().getHitWay();
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
            return TypeClick.move;
        }
    }
    public void internalMove(Block sourceBlock, Block destinyBlock){
        
        table.MovePiece(sourceBlock.getVetor(), destinyBlock.getVetor());
        table.getBlock(click1.getVetor()).colorDefault();
        movingPiece = false;//desabilita a movimentação
        destinyBlock.getPiece().lifeBarRealocate();
        if(wiz != null) {  
            wiz.youShallNotPass(sourceBlock, destinyBlock);
        }
        if(destinyBlock.getPiece() == null) return;
        for(int j = destinyBlock.getVetor().getY() + 1; j < 8; j++){
            if(!table.getBlock(destinyBlock.getVetor().getX(), j).isEmpty())
                table.getBlock(destinyBlock.getVetor().getX(), j).getPiece().AllToFront();
            if(wiz!=null && wiz.getWallVetorY() == j) wiz.wallToFront(destinyBlock.getVetor().getX());
        }
        for(int j = destinyBlock.getVetor().getY() - 1; j >= 0; j--){
            if(!table.getBlock(destinyBlock.getVetor().getX(), j).isEmpty())
                table.getBlock(destinyBlock.getVetor().getX(), j).getPiece().AllToBack();
            if(wiz!=null && wiz.getWallVetorY() == j) wiz.wallToBack(destinyBlock.getVetor().getX());
        }
        clearHighlight();
    }
    public void externalMove(Block sourceBlock, Block destinyBlock){
        moveImage(sourceBlock.getVetor(), destinyBlock.getVetor());
        char letraSource, letraDest;
        int numSource, numDest;
        letraSource = (char) (65 + sourceBlock.getVetor().getX());
        letraDest = (char) (65 + destinyBlock.getVetor().getX());
        numDest = destinyBlock.getVetor().getY() + 1;
        numSource = sourceBlock.getVetor().getY() + 1;
        gameCtrl.displayMessage(playing.getName(), "Peça movida de " + letraSource + numSource +
                " para a posição " + letraDest + numDest + "!\n");
    }
    public void moveImage(Vetor source, Vetor dest) {
        // Pega a peça que está no source
        ImageView pieceToMove = table.getBlock(source).getPiece();
        // Movimenta essa peça
        animation(source, dest, pieceToMove);
        pieceToMove.setLayoutX(65*dest.getX());
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
    }
    public void animation(Vetor source, Vetor destiny, ImageView image){
        int deltaX = destiny.getX() - source.getX();
        int deltaY = destiny.getY() - source.getY();
        TranslateTransition anim = new TranslateTransition();
        for(int i = 1; i <= 5; i++){
            switch(i){
                case 1: anim = new TranslateTransition(Duration.millis(1000), image); break;
                case 2: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getLifeBar()); break;
                case 3: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getLifeBarBg()); break;
                case 4: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getBullet(1)); break;
                case 5: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getBullet(2)); break;
            }
            anim.setFromX(-65*deltaX);
            anim.setFromY(-65*deltaY);
            anim.setToX(0);
            anim.setToY(0);
            anim.setCycleCount(1);
            anim.setAutoReverse(true);
            anim.play();
        }
    }
    public void showHit(ImageView piece) throws InterruptedException{
        for(int i = 0; i < 3; i++){
            piece.setOpacity(0);
            piece.wait(500);
            piece.setOpacity(1);
            piece.wait(500);
        }
    }
    public void OnBlockEnter(MouseEvent e) {
        Block blockOver = (Block) e.getSource();
        if(blockOver.getPiece() != null)
            System.out.println("Essa peça tem " + blockOver.getPiece().getHP());
    }
    public void removeImage(Vetor source) {
        Piece pieceToRemove = table.getBlock(source).getPiece();
        pieceToRemove.removePiece();
        pieceToRemove = null;
    }
    public void removeImage(Block blockSource){
        try{
            Piece pieceToRemove = blockSource.getPiece();
            pieceToRemove.removePiece();
            pieceToRemove = null;
        }catch(NullPointerException e){ }
    }
    public void showPossibleWays(ArrayList<Block> freeWay) {
        if(freeWay == null) {
            return;
        }
        for(Block b : freeWay) {
            b.colorChange(0);
        }
    }
    public void showPossibleEnemys(ArrayList<Block> hitWay) {
        if(hitWay == null) {
            return;
        }
        for(Block b : hitWay) {
            b.colorChange(1);
        }
    }
    public void EndOfTurn() {
        movingPiece = false;
        selectedVetor = null;
        if(possibleBlocks != null) possibleBlocks.clear();
        if(possibleHits != null) possibleHits.clear();

        clearHighlight();
        playing.getHero().GameManager(table);
        if(estacao != null) showSeasons(estacao.getEstacao());
        Players.passTurn();
        playing = Players.getTurn() == 1 ? player1 : player2;
        if(estacao != null) showSeasons(estacao.getEstacao());
        gameCtrl.superPowerBtnManager();
        System.err.println("to aq");
    }
    public void OnBlockClicked(MouseEvent e){
        clickSequence = true;
        while(clickSequence){
            switch(tpClick){
                case first:        clickOnBlock = new FirstClick(this, click1);
                    break;
                case move:         clickOnBlock = new MoveClick(this, click1);
                    break;
                case reaction:     clickOnBlock = new ReactionClick(this, click1);
                    break;
                case hit:          clickOnBlock = new HitClick(this, click1);
                    break;
                case sheriffTower: clickOnBlock = sheriffBlock.getSheriffTower(this, click1);
                    break;
                case special:      clickOnBlock = new SpecialClick(this, click1);
                    break;
                case moveSpecial:  clickOnBlock = new MoveSpecialClick(this, click1);
                    break;
                case last:         clickOnBlock = new LastClick(this);
                    break;
                case wizardClick:  clickOnBlock = new WizardClick(this);
                    break;
            }
            click2 = (Block) e.getSource();
            tpClick = clickOnBlock.click(click2);
        }
    }
    public void displayMessage(String sender, String message) {
        gameCtrl.displayMessage(sender, message);
    }
    public void SuperPowerBtn() {
        if(combo) return;
        if(playing.getHero().getHeroType() == TypeHero.lapa && !movingPiece) {
            if(superPower) {
                superPower = false;
                clearHighlight();
            } else {
                Lapa lapa = (Lapa) playing.getHero();
                if(lapa.getBigBig() >= 5) {
                    possibleBlocks = lapa.getBombWays(table, playing);
                    if(possibleBlocks.isEmpty()) {
                        return;
                    }
                    displayMessage("Lapa", "Está preparando seus poderosos Bigbigs para atacar!");
                    showPossibleEnemys(possibleBlocks);
                    superPower = true;
                } else {
                    displayMessage(gameName, "Lapa você está sem bigbig, precisa de mais alunos interessados!");
                }
            }
        }
        
        if(playing.getHero().getHeroType() == TypeHero.huebr && !movingPiece) {
            Huebr huebr = (Huebr) playing.getHero();
            huebr.setUsePower(true);
            if(huebr.Contador() <= 2){
            displayMessage("Hue", "Huebr acaba de causar problemas! Joga dois turnos!");
            System.out.println("Power ativado");
            }else{
                displayMessage("Hue", "Huee Hueeee, já falei para parar de ser corrupto, ja usou seu poder " + huebr.Contador() + " vezes");
            }
        }

        if(playing.getHero().getHeroType() == TypeHero.wizard && !movingPiece) {
            if(superPower) {
                superPower = false;
                clearHighlight();
            } else {
                Wizard mago = (Wizard) playing.getHero();
//                System.out.println("Entrei2");
                if(!mago.isWallSetted() || mago.getCanMove()) {
                    //System.out.println("Entrei");
                    displayMessage(Players.getActualPlayer().getName(), "Contemplem o mago!!");
                    possibleBlocks = mago.getWallWays(table);
                    showPossibleWays(possibleBlocks);
                    tpClick = TypeClick.wizardClick;
                }
            }
        }
    }
    public void showSeasons(int count){
        switch(count){
            case 1:
                gameCtrl.season.setText("Inverno");
                break;
            case 2:
                gameCtrl.season.setText("Outono");
                break;
            case 3:
                gameCtrl.season.setText("Verão");
                break;
            case 4:
                gameCtrl.season.setText("Primavera");
                break;
        }
    }
    //getset>>
    public void setSheriffBlock(Block sheriffBlock){
        this.sheriffBlock = sheriffBlock;
    }
    public Block getSheriffBlock(){
        return sheriffBlock;
    }
    public Player getPlaying(){
        return playing;
    }
    public Wizard getWizard() {
        return wiz;
    }
    public Table getTable(){
        return table;
    }
    public void setClickSequence(boolean clickSequence){
        this.clickSequence = clickSequence;
    }
    public void setClick1(Block click1){
        this.click1 = click1;
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void setPlaying(Player playing){
        this.playing = playing;
    }
    public GameCtrl getGameCtrl(){
        return gameCtrl;
    }
    public ArrayList<Block> getPossibleBlocks() {
        return possibleBlocks;
    }
    public void setPossibleBlocks(ArrayList<Block> possibleBlocks) {
        this.possibleBlocks = possibleBlocks;
    }
    public ArrayList<Block> getPossibleHits() {
        return possibleHits;
    }
    public void setPossibleHits(ArrayList<Block> possibleHits) {
        this.possibleHits = possibleHits;
    }
    public GridPane getGridPane() {
        return gameCtrl.gridPane;
    }
    public Pane getPratoPieces() {
        return gameCtrl.pratoPieces;
    }
}
