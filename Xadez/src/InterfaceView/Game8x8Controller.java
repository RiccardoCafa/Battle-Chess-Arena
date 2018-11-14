package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Sheriff;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Game8x8Controller implements Initializable {

    @FXML
    GridPane gridPane;
    
    Vetor myVector;
    Vetor selectedVector;
    
    ArrayList<Block> possibleBlocks;
    
    boolean movingPiece = false;
    
    Table tab;
    
    Player player1;
    Player player2;
    Player playing;
    
//    Image whiteBlock = new Image("InterfaceView/imagens/blocoBranco.png", 62, 62, false, false );
//    Image blackBlock = new Image("InterfaceView/imagens/blocoPreto.png", 62, 62, false, false );
//    Image greenBlock = new Image("InterfaceView/imagens/blocoVerde.png", 62, 62, false, false );
//    Image redBlock = new Image("InterfaceView/imagens/blocoVermelho.png", 62, 62, false, false );;
    //Image rei = new Image("InterfaceView/imagens/lapaPieces/lapaKing.png", 57, 130, false, false);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1 = new Player(1, new Lapa(null), 1);
        player2 = new Player(1, new Sheriff(null), 2);
        playing = player1;
        tab = new Table(8, 8, player1, player2);
        Bishop c = new Bishop(player1, TypeHero.lapa, 1, 4);
        Tower t = new Tower(player1, TypeHero.lapa, 2, 3, new LapaTower(player1));
        tab.getTable()[2][3].setPiece(t);
        tab.getTable()[1][4].setPiece(c);
        MountArmyOnTable(tab);
        //MoveImage(new Vetor(2, 3), new Vetor(5, 5));
    }    
    
    public void MountArmyOnTable(Table tab) {
        Image pieceImage = null;
        
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if(!tab.getBlock(i, j).isEmpty()) {
                    pieceImage = tab.getBlock(i, j).getPiece().getImage();
                }
                gridPane.add(makeBloco(i, j, pieceImage), i, j);  
                pieceImage = null;
            }
        }
    }
    
    public Pane makeBloco(int i, int j, Image pieceImg) {
        Pane bloco = new Pane();
        ImageView g;
        g = tab.getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            OnPieceClicked(e);
        });
        
        //g = white == true ? new ImageView(whiteBlock) : new ImageView(blackBlock);
        bloco.getChildren().add(g);
        if(pieceImg != null) {
            ImageView p1 = new ImageView(pieceImg);
            p1.setLayoutX(2.5);
            p1.setLayoutY(-75);
            bloco.getChildren().add(p1);
        }
         
        return bloco;
    }
    
    public void OnPieceClicked(MouseEvent e) {
        Block myBlock = (Block) e.getSource();
        if(!movingPiece) {
            if(!myBlock.isEmpty()) {
                selectedVector = new Vetor(myBlock.getVetor());
                movingPiece = true;
                //myBlock.colorChange(0, playing);
                myBlock.getPiece().checkMove(tab);
                possibleBlocks = myBlock.getPiece().getFreeWay();
                showPossibleWays(possibleBlocks);
                System.out.println("Selected Piece");
            } else {
                System.out.println("Nothing here");
            }
        } else {
            if(myBlock.isEmpty() && possibleBlocks.contains(myBlock)) {
                Vetor novaPos = new Vetor(myBlock.getVetor());
                MoveImage(selectedVector, novaPos);
                tab.MovePiece(selectedVector, novaPos);
                tab.getBlock(selectedVector).colorDefault();
                movingPiece = false;
                resetBlockTab();
                System.out.println("Moved Piece");
            }
        }
    }
    
    public void MoveImage(Vetor source, Vetor dest) {
        ObservableList<Node> childrens = gridPane.getChildren();
        Pane myPane= null;
        Pane destPane = null;
        for (Node p : childrens) {
            if(myPane == null && GridPane.getRowIndex(p) == source.getY() && GridPane.getColumnIndex(p) == source.getX()) {
                myPane = (Pane) p;
            }
            if(destPane == null && GridPane.getRowIndex(p) == dest.getY() && GridPane.getColumnIndex(p) == dest.getX()) {
                destPane = (Pane) p;
            }
            if(destPane != null && myPane != null) {
                break;
            }
        }
        if(myPane == null || destPane == null) return;
        
        Node tempPane = myPane.getChildren().get(1);
        myPane.getChildren().remove(1);
        destPane.getChildren().add(1, tempPane);
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
    
    public void resetBlockTab() {
        for(int i = 0; i < Table.getN(); i++) {
            for(int j = 0; j < Table.getM(); j++) {
                tab.getBlock(i, j).colorDefault();
            }
        }
    }
    
//    public void OnBlockSelected() {
//        
//        if(tab.getBlock(selectedVector).isEmpty()) {
//            System.out.println("Onde voce clicou não há peça");
//        } else {
//            System.out.println("Voce encontrou uma peça! Aqui estão as possíveis movimentações dela:");
//            tab.getBlock(selectedVector).getPiece().checkMove(tab);
//            possibleBlocks = tab.getBlock(selectedVector).getPiece().getFreeWay();
//        }
//    }
    
}