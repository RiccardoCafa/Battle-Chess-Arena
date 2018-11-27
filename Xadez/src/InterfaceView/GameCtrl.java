package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.BlockState;
import extras.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
        player1 = new Player(-1, new Wizard(), 1);
        player2 = new Player(1, new Lenin(), 2);
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
            //if(e.isPrimaryButtonDown())
                OnBlockClicked(e);
        });
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            //if(e.isSecondaryButtonDown())
                OnBlockEnter(e);
        });
        return g;
    }
    
    public void OnBlockClicked(MouseEvent e){//evento de click para os blocos
        Block actualBlock = (Block) e.getSource();//bloco clicado
        if(!combo && !actualBlock.isEmpty() &&                                  //se o bloco clicado não está vazio e
           actualBlock.getBlockState(playing) == BlockState.Friend &&//clicar em uma peça aliada e
           selectedVetor != null){                                  //já tiver sido clicada uma peça
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
                //externalMove(firstBlock, actualBlock);
                if(!possibleHits.contains(actualBlock)){//se é caminho livre, ou seja, não há inimigos
                    externalMove(firstBlock, actualBlock);
                    internalMove(firstBlock, actualBlock);
                    EndOfTurn();
                    combo = false;
                }else if(actualBlock.getBlockState(playing) == BlockState.Enemy){//se há inimigo
                    /*
                    HIT
                    */
                    if(!actualBlock.hitPiece(firstBlock.getPiece().getDamage())){ // Hita a peça e retorna se está morto
                        // Está vivo
                        if(!firstBlock.getPiece().isSpecial()){ // se a peça não for especial
                            Vetor lastPos = firstBlock.getPiece().getLastPosOf(actualBlock); // Pega a melhor posição para ficar
                            externalMove(firstBlock, table.getBlock(lastPos));
                            internalMove(firstBlock, table.getBlock(lastPos));
                        } else {
                            possibleBlocks = firstBlock.getPiece().getSpecialMovesLikeJagger(table, actualBlock.getVetor()); // Pega o novo free way
                            if(possibleBlocks.isEmpty()) {
                                EndOfTurn();
                                return;
                            }
                            if(possibleBlocks.size() == 1) {
                                externalMove(firstBlock, possibleBlocks.get(0));
                                internalMove(firstBlock, possibleBlocks.get(0));
                                EndOfTurn();
                                return;
                            }
                            resetBlockTab(); // Reseta os highlights
                            showPossibleWays(possibleBlocks); // Mostra o novo highlight
                            combo = true; // Torna combo true
                            // TODO CHECAR DEPOIS DE POSSIBLE BLOCKS ESTIVER VAZIO PARA TRATAR ISSO AI 
                            //(isso provavelmente pode ocorrer com peças que pulam)
                        }
                    } else {
                        // Morreu o mizeravel
                        removeImage(actualBlock); // remove a imagem do mizere
                        externalMove(firstBlock, actualBlock); 
                        internalMove(firstBlock, actualBlock);
                    }
                    if(!combo) {
                        EndOfTurn(); // Se não tiver combo, passa o turno
                    }
                }
                /* else { ISSO OCORRE QUANDO NÃO HÁ INIMIGO - ESTÁ INDO PARA UMA POSIÇÃO VAZIA 
                    EndOfTurn();
                }*/
            }else if(actualBlock.isEmpty()){//se está vazio
                if(combo) return;
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
            }
        }
    }
    
    public void EndOfTurn() {
        firstBlock = null;
        movingPiece = false;
        selectedVetor = null;
        possibleBlocks.clear();
        possibleHits.clear();
        resetBlockTab();
        Players.passTurn();
        playing.getHero().GameManager(table);
        playing = Players.getTurn() == 1 ? player1 : player2;
    }
    
    @FXML
    public void OnBlockEnter(MouseEvent e) {
        Block blockOver = (Block) e.getSource();
        if(blockOver.getPiece() != null)
            System.out.println("Essa peça tem " + blockOver.getPiece().getHP());
    }
    
    public void firstClick(Block actualBlock){
        if(actualBlock.isEmpty()){//se o bloco está vazio
            firstBlock = null;
            movingPiece = false;
            selectedVetor = null;
            resetBlockTab();
            //System.out.println("Nada aqui");
        }else{//se há peça
            if(playing != actualBlock.getPiece().getPlayer()){//se a peça desse bloco é do outro jogador
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                //System.out.println("Nao é seu turno babaca");
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
            //System.out.println("Saindo aqui vlw flw");
            return false;
        }else{
            possibleHits = actualBlock.getPiece().getHitWay();
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
            //System.out.println("Selected Piece");
            return true;
        }
    }
    public void showAlternativeMoves(Block actualBlock){
        firstBlock.getPiece().checkEspecialMove(table, actualBlock);
        possibleBlocks = firstBlock.getPiece().getEspecialFreeWay();
        if(possibleBlocks == null){//se o freeWay for vazio ou nulo, saia do evento
            //System.out.println("Saindo aqui vlw flw, sou o cara");
        }else{
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
        }
    }
    
    public void internalMove(Block sourceBlock, Block destinyBlock){
        table.MovePiece(sourceBlock.getVetor(), destinyBlock.getVetor());
        table.getBlock(selectedVetor).colorDefault();
        movingPiece = false;//desabilita a movimentação
        resetBlockTab();
    }
    public void externalMove(Block sourceBlock, Block destinyBlock){
        moveImage(sourceBlock.getVetor(), destinyBlock.getVetor());
    }
    
    public void moveImage(Vetor source, Vetor dest) {
        // Pega a peça que está no source
        ImageView pieceToMove = table.getBlock(source).getPiece();
        // Movimenta essa peça
        pieceToMove.setLayoutX((65*dest.getX()));
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
        // Faz uma iteração para colocar as crianças da hierarquia em ordem no pane
        Vetor vet;
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
            vet = new Vetor(dest.getX(), y);
            if(table.getBlock(vet).isEmpty()) {
                break;
            }
            pieceToMove = table.getBlock(vet).getPiece();
            pieceToMove.toBack();
            y--;
        }
    }
    public void removeImage(Vetor source) {
        ImageView pieceToRemove = table.getBlock(source).getPiece();
        pieceToRemove.setVisible(false);
        pieceToRemove = null;
    }
    public void removeImage(Block blockSource) {
        ImageView pieceToRemove = blockSource.getPiece();
        pieceToRemove.setVisible(false);
        pieceToRemove = null;
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
    
    public void resetBlockTab() {
        for(int i = 0; i < Table.getN(); i++) {
            for(int j = 0; j < Table.getM(); j++) {
                table.getBlock(i, j).colorDefault();
            }
        }
    }

    @FXML
    public void OnBtnPower(MouseEvent e) {
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
    }
}
