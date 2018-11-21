package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    Vetor selectedVector;
    
    ArrayList<Block> possibleBlocks;
    ArrayList<Block> possibleHits;
    
    boolean movingPiece = false;
    boolean superPower = false;
    boolean specialActive  = false;
    
    Table table;
    
    Player player1;
    Player player2;
    Player playing;
    
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
        if(player1.getHero().getHeroType() != TypeHero.lapa && player2.getHero().getHeroType() != TypeHero.lapa) {
            btnPower.setVisible(false);
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
                gridPane.add(makeBloco(i, j), i, j);
                //pieceImage = null;
            }
        }
    }
    
    public ImageView makeBloco(int i, int j) {
        // Pega um bloco do table, cria um evento pra ele e o add no gridpane
        ImageView g;
        g = table.getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            OnBlockClicked(e);
        });
         
        return g;
    }
    
    public void OnBlockClicked(MouseEvent e) { 
        //Evento de click para os blocos
        Block myBlock = (Block) e.getSource();
        Block firstBlock = null;
        if(!movingPiece && !superPower){//primeiro clique para escolher uma peça
            firstBlock = firstClick(myBlock);
        } else if(movingPiece && !superPower){
            //Caso já tenha clicado uma vez, mexa essa peça
            if(myBlock.isEmpty() && possibleBlocks.contains(myBlock)){//caso seja um bloco vazio e valido para mover
                moveAction(myBlock);
                specialActive = false;
                Players.passTurn();
                playing.getHero().GameManager(table);
                playing = Players.getTurn() == 1 ? player1 : player2;
            }else if(possibleHits.contains(myBlock)){//caso seja um inimigo válido para atacar
                myBlock.getPiece().reaction(table);
                if(firstBlock != null){
                    myBlock.getPiece().hit(firstBlock.getPiece().getDamage());
                    specialActive = false;
                    if(myBlock.getPiece().imAlive()){//caso a peça atingida não não morra
                        if(firstBlock.getPiece().isSpecial()){//caso a peça movida seja especial
                            specialActive = true;
                            possibleBlocks = table.blocksAround(firstBlock);
                            possibleHits = myBlock.getPiece().updateHitWay(table, possibleBlocks);
                            resetBlockTab();
                            showPossibleWays(possibleBlocks);
                            showPossibleEnemys(possibleHits);
                        }
                        MoveImage(selectedVector, firstBlock.getPiece().getVetor().next());
                        table.MovePiece(selectedVector, firstBlock.getPiece().getVetor().next());
                    }
                }
            }else if(myBlock.getVetor().getX() == selectedVector.getX() &&
                      myBlock.getVetor().getY() == selectedVector.getY() && !specialActive){
                movingPiece = false;
                resetBlockTab();
            }
        } else if(!movingPiece && superPower){
            if(playing.getHero().getHeroType() == TypeHero.lapa && possibleBlocks.contains(myBlock)) { 
                Lapa lapa = (Lapa) playing.getHero();
                lapa.ExplodeBomb(table, new Vetor(myBlock.getVetor()));
                resetBlockTab();
                superPower = false;
            }
        }
    }
    
    public Block firstClick(Block myBlock){
        if(!myBlock.isEmpty()){
            if(playing != myBlock.getPiece().getPlayer()) {//caso seja selecionada uma peça que não pode mover
                System.out.println("Nao é seu turno babaca");
                return null;
            }
            selectedVector = new Vetor(myBlock.getVetor());
            myBlock.getPiece().checkMove(table);
            possibleBlocks = myBlock.getPiece().getFreeWay();
            possibleHits = myBlock.getPiece().getHitWay();
            if(possibleBlocks == null || possibleBlocks.isEmpty()) {//caso não haja movimentos possiveis
                // Caso o free way for vazio ou nulo, saia do evento
                System.out.println("Saindo aqui vlw flw");
                return null;
            }
            movingPiece = true;
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
            System.out.println("Selected Piece");
        } else {//caso clique num bloco vazio
            System.out.println("Nothing here");
        }
        return myBlock;
    }
    
    public void moveAction(Block myBlock){
        Vetor novaPos = new Vetor(myBlock.getVetor());
        MoveImage(selectedVector, novaPos);
        table.MovePiece(selectedVector, novaPos);
        table.getBlock(selectedVector).colorDefault();
        movingPiece = false;
        resetBlockTab();
        System.out.println("Moved Piece");
    }
    
    public void MoveImage(Vetor source, Vetor dest) {
        //Mexe a imagem na interface
        ImageView pieceToMove = table.getBlock(source).getPiece();
        pieceToMove.setLayoutX((65*dest.getX()));
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
    }
    
    public void showPossibleWays(ArrayList<Block> freeWay) {
        if(freeWay == null) {
            System.out.println("Lista vazia");
            return;
        }
        for(Block b : freeWay) {
            b.colorChange(0);
        }
    }
    
    public void showPossibleEnemys(ArrayList<Block> hitWay) {
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
        if(playing.getHero().getHeroType() == TypeHero.lapa) {
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