package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import extras.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    /*
        DECLARING GAMECORE VARIAVABLES
    */
    Vetor myVector;
    Vetor selectedVector;
    
    ArrayList<Block> possibleBlocks;
    
    boolean movingPiece = false;
    boolean superPower = false;

    int turn = 1;
    
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
        player1 = new Player(1, new Sheriff(), 1);
        player2 = new Player(-1, new Lapa(), 2);
        Players.setPlayer1(player1);
        Players.setPlayer2(player2);
        playing = player1;
        table = new Table(8, 8, player1, player2);
        
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
                pieceImage = null;
            }
        }
    }
    
    public ImageView makeBloco(int i, int j) {
        // Pega um bloco do table, cria um evento pra ele e o add no gridpane
        ImageView g;
        g = table.getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            OnPieceClicked(e);
        });
         
        return g;
    }
    
    public void OnPieceClicked(MouseEvent e) { 
        //Evento de click para os blocos
        Block myBlock = (Block) e.getSource();
        if(!movingPiece){//primeiro clique para escolher uma peça
            if(!myBlock.isEmpty()){
                if(playing != myBlock.getPiece().getPlayer()) {
                    System.out.println("Nao é seu turno babaca");
                    return;
                }
                selectedVector = new Vetor(myBlock.getVetor());
                myBlock.getPiece().checkMove(table);
                possibleBlocks = myBlock.getPiece().getFreeWay();
                if(possibleBlocks == null || possibleBlocks.isEmpty()) {
                    // Caso o free way for vazio ou nulo, saia do evento
                    System.out.println("Saindo aqui vlw flw");
                    return;
                }
                movingPiece = true;
                showPossibleWays(possibleBlocks);
                showPossibleEnemys(myBlock.getPiece().getHitWay(), notPlaying());
                System.out.println("Selected Piece");
            } else {
                System.out.println("Nothing here");
            }
        } else {
            //Caso já tenha clicado uma vez, mexa essa peça
            if(myBlock.isEmpty() ) {
                Vetor novaPos = new Vetor(myBlock.getVetor());
                MoveImage(selectedVector, novaPos);
                table.MovePiece(selectedVector, novaPos);
                table.getBlock(selectedVector).colorDefault();
                movingPiece = false;
                resetBlockTab();
                System.out.println("Moved Piece");
            } else if(myBlock.getVetor().getX() == selectedVector.getX() &&
                      myBlock.getVetor().getY() == selectedVector.getY()){
                movingPiece = false;
                resetBlockTab();
            }
        }
    }
    
    public void MoveImage(Vetor source, Vetor dest) {
        //Mexe a imagem na interface
        ImageView pieceToMove = table.getBlock(source).getPiece();
        pieceToMove.setLayoutX((65*dest.getX()));
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
        
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
    }
    
    public void showPossibleWays(ArrayList<Block> freeWay) {
        if(freeWay == null) {
            System.out.println("Lista vazia");
            return;
        }
        for(Block b : freeWay) {
            b.colorChange(0, playing);
        }
    }
    
    public void showPossibleEnemys(ArrayList<Block> hitWay, Player pAsking) {
        if(hitWay == null) {
            System.out.println("Lista vazia");
            return;
        }
        for(Block b : hitWay) {
            b.colorChange(1, pAsking);
        }
    }
    
    public void resetBlockTab() {
        for(int i = 0; i < Table.getN(); i++) {
            for(int j = 0; j < Table.getM(); j++) {
                table.getBlock(i, j).colorDefault();
            }
        }
    }
}