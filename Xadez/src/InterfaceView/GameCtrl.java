package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.BlockState;
import extras.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameCtrl implements Initializable {
    /*
        REFERENCING ALL THE FXML OBJECTS
    */
    @FXML
    GridPane gridPane;
    @FXML
    AnchorPane background;
    @FXML
    ImageView persoImage;
    @FXML
    Pane paneRef;
    @FXML
    Pane pratoPieces;
    @FXML
    Button btnPower;
    
    /*
        DECLARING GAMECORE VARIAVABLES
    */
    Vetor myVector;
    Vetor selectedVetor;
    
    ArrayList<Block> possibleBlocks;
    ArrayList<Block> possibleHits;
    
    boolean movingPiece = false;
    boolean superPower = false;
    boolean specialActive = false;
    boolean combo = false;
    
    Table table;
    
    Player player1;
    Player player2;
    Player playing;
    
    Block firstBlock;
    
    public Player notPlaying(){
        return playing.equals(player1) ? player2 : player1;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setBackground(new Background( new BackgroundImage(new Image("InterfaceView/imagens/fundoJogo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        player1 = new Player(-1, new Lapa(), 1);
        player2 = new Player(1, new Sheriff(), 2);
        Players.setPlayer1(player1);
        Players.setPlayer2(player2);
        playing = player1;
        table = new Table(8, 8, player1, player2);
        if(playing.getHero().getHeroType() != TypeHero.lapa) {
            btnPower.setVisible(false);
        } else { 
            btnPower.setVisible(true);
        }
        MountArmyOnTable(table);
    }
    
    public void MountArmyOnTable(Table tab) {
        ImageView pieceImage;
        // Initializing the table with pieces from each army
        for(int i = 0; i < Table.getM(); i++){
            for(int j = 0; j < Table.getN(); j++){
                if(table.getBlock(i, j).getPiece() == null){
                    table.getBlock(i, j).setPiece(player1.getArmy().findPiece(i, j));
                }
                if(table.getBlock(i, j).getPiece() == null){
                    table.getBlock(i, j).setPiece(player2.getArmy().findPiece(i, j));
                }
            }
        }
        // Initializing the interface with images of blocks and pieces.
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if(!tab.getBlock(i, j).isEmpty()) {
                    pieceImage = tab.getBlock(i, j).getPiece();
                    pratoPieces.getChildren().add(pieceImage);
                    pieceImage.setLayoutX((65*i));
                    pieceImage.setLayoutY(-75 + (65*j));
                }
                gridPane.add(makeBlock(i, j), i, j);
                //pieceImage = null;
            }
        }
    }
    
    public ImageView makeBlock(int i, int j) {
        // Pega um bloco do table, cria um evento pra ele e o add no gridpane
        ImageView g;
        g = table.getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            OnBlockClicked(e);
        });
        g.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            OnBlockEnter(e);
        });
        return g;
    }
    
    public void OnBlockClicked(MouseEvent e){//evento de click para os blocos
        Block actualBlock = (Block) e.getSource();//bloco clicado
        if(!actualBlock.isEmpty() &&                                  //se o bloco clicado não está vazio e
           actualBlock.getBlockState(playing) == BlockState.Friend &&//clicar em uma peça aliada e
           selectedVetor != null){                                  //já tiver sido clicada uma peça
            if(combo) return;
            if(actualBlock != firstBlock){//se a peça clicada for outra aliada
                resetBlockTab();
                movingPiece = false;
            }
        }
        if(!movingPiece){//primeiro clique
            firstClick(actualBlock);
        }else{//segundo clique
            if(actualBlock == firstBlock){//se o bloco é o mesmo clicado antes
                if(combo) return;
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
            }else if(possibleBlocks.contains(actualBlock)){//se é possível se movimentar
                externalMove(firstBlock, actualBlock, firstBlock.getPiece());
                if(!possibleHits.contains(actualBlock)){//se é caminho livre
                    externalMove(firstBlock, actualBlock, firstBlock.getPiece());
                    internalMove(firstBlock, actualBlock);
                    combo = false;
                }else{//se há inimigo
                    while(!actualBlock.isEmpty()){//enquanto não houver casa livre
                        if(!firstBlock.getPiece().isSpecial()){//se a peça não for especial
                            if(actualBlock.getBlockState(playing) == BlockState.Enemy){//se a casa atual possui inimigo
                                System.out.println("inimigo encontrado");
                                actualBlock.getPiece().reaction(table);
                                if(actualBlock.hitPiece(firstBlock.getPiece().getDamage())){//se ainda está viva
                                    System.out.println("inimigo não abatido");
                                    externalMove(actualBlock, table.getBlock(actualBlock.getVetor().next()), firstBlock.getPiece());
                                    actualBlock = table.getBlock(actualBlock.getVetor().next());
                                }
                            }else{//se a casa atual não possui inimigo
                                externalMove(actualBlock, table.getBlock(actualBlock.getVetor().next()), firstBlock.getPiece());
                                removeImage(actualBlock.getVetor());
                                actualBlock = table.getBlock(actualBlock.getVetor().next());
                            }
                        }else{//se a peça for especial
                            if(actualBlock.getBlockState(playing) == BlockState.Enemy){//se a casa atual possui inimigo
                                actualBlock.getPiece().reaction(table);
                                if(actualBlock.hitPiece(firstBlock.getPiece().getDamage())){//se ainda está viva
                                    resetBlockTab();
                                    showAlternativeMoves(actualBlock);
                                    combo = true;
                                    return;
                                }else{//se a peça atingida morreu
                                    combo = false;
                                }
                            }else{//se a casa atual está livre
                                combo = false;
                                externalMove(actualBlock, table.getBlock(actualBlock.getVetor().next()), firstBlock.getPiece());
                                removeImage(actualBlock.getVetor());
                            }
                        }
                    }
                    externalMove(firstBlock, actualBlock, firstBlock.getPiece());
                    internalMove(firstBlock, actualBlock);
                    Players.passTurn();
                    playing.getHero().GameManager(table);
                    playing = Players.getTurn() == 1 ? player1 : player2;
                    return;
                }
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
                Players.passTurn();
                playing.getHero().GameManager(table);
                playing = Players.getTurn() == 1 ? player1 : player2;
            }else if(actualBlock.isEmpty()){//se está vazio
                if(combo) return;
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
            }else if(!actualBlock.isEmpty() &&
                     actualBlock.getPiece().getPlayer() == firstBlock.getPiece().getPlayer()){//se clicar num aliado
                if(combo) return;
                firstClick(actualBlock);
            }else{//se clicar num inimigo fora de alcance
                if(combo) return;
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
            }
        }
        
        /*
        if(!actualBlock.isEmpty() &&                                 //se o bloco clicado não está vazio e
           actualBlock.getBlockState(playing) == BlockState.Friend &&//possuir uma peça aliada e
           selectedVetor != null){                                   //ja tiver sido clicada uma peça
            if(selectedVetor.getX() != actualBlock.getVetor().getX() ||
               selectedVetor.getY() != actualBlock.getVetor().getY()){//se a peça clicada for outra aliada
                resetBlockTab();
                movingPiece = false;
            }else{
                resetBlockTab();
                movingPiece = false;
                selectedVetor = null;
            }
        }
        if(!movingPiece && !superPower){//se for o primeiro clique para escolher uma peça
            firstBlock = actualBlock;
            firstClick(actualBlock);
        }else if(movingPiece && !superPower){//se já tenha clicado uma vez, mexa essa peça
            if(!possibleBlocks.isEmpty() &&
               possibleBlocks.contains(actualBlock)){//se o bloco está vazio e válido para mover
                moveAction(actualBlock);
                specialActive = false;
                Players.passTurn();
                playing.getHero().GameManager(table);
                playing = Players.getTurn() == 1 ? player1 : player2;
            }else if(!possibleHits.isEmpty() &&
                     possibleHits.contains(actualBlock)){//se o bloco possui um inimigo válido para atacar
                actualBlock.getPiece().reaction(table);
                if(firstBlock != null){
                    specialActive = false;
                    if(actualBlock.hitPiece(firstBlock.getPiece().getDamage())){//caso a peça atingida não morra
                        moveImage(firstBlock.getVetor(), actualBlock.getVetor());
                        //table.MovePiece(firstBlock.getVetor(), actualBlock.getVetor());//!!!!!!!!!!!!!!!!!!!!
                        if(firstBlock.getPiece().isSpecial()){//caso a peça movida seja especial
                            specialActive = true;
                            possibleBlocks = table.blocksAround(firstBlock);
                            possibleHits = actualBlock.getPiece().updateHitWay(table, possibleBlocks);
                            resetBlockTab();
                            showPossibleWays(possibleBlocks);
                            showPossibleEnemys(possibleHits);
                        }else{
                            Block previousBlock = actualBlock;
                            while(!table.getBlock(actualBlock.getVetor().next()).isEmpty()){//enquanto o próximo bloco não está vazio
                                previousBlock = actualBlock;
                                actualBlock = table.getBlock(actualBlock.getVetor().next());
                                switch(actualBlock.getBlockState(playing)){
                                    case Friend:
                                        GameCtrl.this.moveImage(previousBlock.getVetor(), actualBlock.getVetor(), firstBlock.getPiece());
                                        System.out.println("opa, amigao, bom te ver");
                                        //table.MovePiece(actualBlock.getVetor(), firstBlock.getVetor());
                                        break;
                                    case Enemy:
                                        actualBlock.getPiece().reaction(table);
                                        GameCtrl.this.moveImage(previousBlock.getVetor(), actualBlock.getVetor(), firstBlock.getPiece());
                                        System.out.println("shoryuken!");
                                        if(!actualBlock.hitPiece(firstBlock.getPiece().getDamage())){//se matou
                                            table.MovePiece(actualBlock.getVetor(), firstBlock.getVetor());
                                            System.out.println("fatality");
                                        }
                                    case Empty:
                                        moveImage(firstBlock.getVetor(), actualBlock.getVetor());
                                }
                            }
                        }
                    }else{
                        moveImage(firstBlock.getVetor(), actualBlock.getVetor());
                        table.MovePiece(firstBlock.getVetor(), actualBlock.getVetor());
                        movingPiece = false;
                    }
                }
            }else if(actualBlock.getVetor().getX() == selectedVetor.getX() &&
                      actualBlock.getVetor().getY() == selectedVetor.getY() && !specialActive){
                movingPiece = false;
                resetBlockTab();
                System.out.println("Moved Piece");
                selectedVetor = null;
                Players.passTurn();
                playing.getHero().GameManager(table);
                playing = Players.getTurn() == 1 ? player1 : player2;
                if(playing.getHero().getHeroType() != TypeHero.lapa) {
                    btnPower.setVisible(false);
                } else { 
                    btnPower.setVisible(true);
                }
            } else if(actualBlock.getVetor().getX() == selectedVetor.getX() &&
                      actualBlock.getVetor().getY() == selectedVetor.getY()){
                movingPiece = false;
                selectedVetor = null;
                resetBlockTab();
                superPower = false;
            }
        }*/
    }
    
    @FXML
    public void OnBlockEnter(MouseEvent e) {
        Block blockOver = (Block) e.getSource();
            //System.out.println("Essa peça tem " + blockOver.getPiece().getHP());
    }
    
    public void firstClick(Block actualBlock){
        if(actualBlock.isEmpty()){//se o bloco está vazio
            firstBlock = null;
            movingPiece = false;
            selectedVetor = null;
            resetBlockTab();
            System.out.println("Nada aqui");
        }else{//se há peça
            if(playing != actualBlock.getPiece().getPlayer()){//se a peça desse bloco é do outro jogador
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                System.out.println("Nao é seu turno babaca");
            }else{//se a peça é sua
                combo = false;
                movingPiece = true;
                firstBlock = actualBlock;
                selectedVetor = new Vetor(actualBlock.getVetor());
                showMoves(actualBlock);
            }
        }
    }
    
    public boolean showMoves(Block actualBlock){
        actualBlock.getPiece().checkMove(table);
        possibleBlocks = actualBlock.getPiece().getFreeWay();
        if(possibleBlocks == null || possibleBlocks.isEmpty()){//se o freeWay for vazio ou nulo, saia do evento
            firstBlock = null;
            movingPiece = false;
            selectedVetor = null;
            resetBlockTab();
            System.out.println("Saindo aqui vlw flw");
            return false;
        }else{
            possibleHits = actualBlock.getPiece().getHitWay();
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
            System.out.println("Selected Piece");
            return true;
        }
    }
    public void showAlternativeMoves(Block actualBlock){
        firstBlock.getPiece().checkEspecialMove(table, actualBlock);
        possibleBlocks = firstBlock.getPiece().getEspecialFreeWay();
        if(possibleBlocks == null){//se o freeWay for vazio ou nulo, saia do evento
            System.out.println("Saindo aqui vlw flw, sou o cara");
        }else{
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
            System.out.println("Selected Piece");
        }
    }
    
    public void internalMove(Block sourceBlock, Block destinyBlock){
        table.MovePiece(sourceBlock.getVetor(), destinyBlock.getVetor());
        table.getBlock(selectedVetor).colorDefault();
        movingPiece = false;//desabilita a movimentação
        resetBlockTab();
        System.out.println("peça movida");
    }
    public void externalMove(Block sourceBlock, Block destinyBlock, ImageView pieceImage){
        GameCtrl.this.moveImage(sourceBlock.getVetor(), destinyBlock.getVetor(), pieceImage);//ta com algum problema
        //table.getBlock(selectedVetor).colorDefault();
        //resetBlockTab();
        System.out.println("peça aparentemente movida");
    }
    
    public void moveImage(Vetor source, Vetor dest, ImageView pieceToMove) {
        //Mexe a imagem na interface
        //int yCount = 1;
        Vetor vet;
        pieceToMove.setLayoutX((65*dest.getX()));
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
        int y = dest.getY() + 1;
        while(y < Table.getN()) {
            vet = new Vetor(dest.getX(), y);
            if(table.getBlock(vet).isEmpty()) {
                break;
            }
            pieceToMove = table.getBlock(vet).getPiece();
            pieceToMove.toFront();
            y++;
        }
        y = dest.getY() - 1;
        while(y >= 0)  {
            System.out.println("Entrei no y: " + y);
            vet = new Vetor(dest.getX(), y);
            if(table.getBlock(vet).isEmpty()) {
                break;
            }
            System.out.println("Não está vazio: " + y);
            pieceToMove = table.getBlock(vet).getPiece();
            pieceToMove.toBack();
            y--;
        }
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    public void moveImage(Vetor source, Vetor dest) {
        //Mexe a imagem na interface
        ImageView pieceToMove = table.getBlock(source).getPiece();
        pieceToMove.setLayoutX((65*dest.getX()));
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    public void removeImage(Vetor source) {
        ImageView pieceToRemove = table.getBlock(source);
        pieceToRemove.setVisible(false);
        pieceToRemove = null;
    }
    public void showPossibleWays(ArrayList<Block> freeWay) {
        System.out.println("entrei em showPossibleWays");
        if(freeWay == null) {
            System.out.println("Lista vazia");
            return;
        }
        for(Block b : freeWay) {
            b.colorChange(0);
        }
    }
    
    public void showPossibleEnemys(ArrayList<Block> hitWay) {
        System.out.println("entrei em showPossibleEnemys");
        if(hitWay == null) {
            System.out.println("Lista vazia");
            return;
        }
        for(Block b : hitWay) {
            b.colorChange(1);
        }
    }
    
    public void resetBlockTab() {
        for(int i = 0; i < Table.getN(); i++) {
            for(int j = 0; j < Table.getM(); j++) {
                table.getBlock(i, j).colorDefault();
            }
        }
    }

    @FXML
    public void OnBtnPower(MouseEvent e) {
        // Lenin
        // Huebr
        if(playing.getHero().getHeroType() == TypeHero.lapa && !movingPiece) {
            if(superPower) {
                superPower = false;
                resetBlockTab();
            } else {
                superPower = true;
                Lapa lapa = (Lapa) playing.getHero();
                possibleBlocks = lapa.getBombWays(table, playing);
                showPossibleEnemys(possibleBlocks);
            }
            
        }
        //playing.getHero()
    }
}


        
        //A little try to change depth by children index
//        if(source.getY() < dest.getY()) {
//            Vetor vetorBaixo = new Vetor(source.getX(), source.getY() + 1);
//            if(vetorBaixo.getY() < 8) {
//
//            }
//        }
//        if(table.getBlock(source.getX(), source.getY() + 1).getPiece())
//        //if(source.getY() < dest.getY()) {
//            pieceToMove.toFront();
//            System.out.println("YO");
        //}
