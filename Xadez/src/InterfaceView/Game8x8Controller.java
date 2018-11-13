package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Sheriff;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import extras.Vetor;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
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
    
    List<Block> possibleBlocks;
    
    boolean movingPiece = false;
    
    Table tab;
    
    Player player1;
    Player player2;
    
    Image whiteBlock = new Image("InterfaceView/imagens/blocoBranco.png", 62, 62, false, false );
    Image blackBlock = new Image("InterfaceView/imagens/blocoPreto.png", 62, 62, false, false );
    Image rei = new Image("InterfaceView/imagens/lapaPieces/lapaKing.png", 57, 130, false, false);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1 = new Player(1, new Lapa(null), 1);
        player1 = new Player(1, new Sheriff(null), 2);
        tab = new Table(8, 8, player1, player2);
        Tower t = new Tower(PlayerPiece.Player1, TypeHero.lapa, 2, 3, new LapaTower(player1));
        tab.getTable()[2][3] = new Block(t, 2, 3);
        MountArmyOnTable(tab);
    }    
    
    public void MountArmyOnTable(Table tab) {
        //Node myNode = null;
        //Node pieceNode = null;
        Image pieceImage = null;
        boolean white;
        
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if((i%2==0 && j%2==0) || (j%2!=0 && i%2!=0)) {
                    //myNode = new ImageView(whiteBlock);
                    white = true;
                }else{
                    //myNode = new ImageView(blackBlock);
                    white = false;
                }
                if(!tab.getBlock(i, j).isEmpty()) {
                    pieceImage = tab.getBlock(i, j).getPiece().getImage();
                    //pieceNode = new ImageView(pieceImage);
                }
                /*
                myNode.setOnMouseReleased((MouseEvent e) -> {
                    if(!movingPiece) {
                        Node myBlock = (Node) e.getSource();
                        if(myBlock != null)
                            selectedVector = new Vetor(
                                            GridPane.getColumnIndex(
                                                    myBlock), 
                                            GridPane.getRowIndex(myBlock));
                        OnBlockSelected();
                        //movingPiece = true;
                    } else {
                        //Checar se a peça que ele clicou é uma peça possível
                        
                    }
                });*/
                gridPane.add(makeBloco(white, pieceImage), i, j);  
                //gridPane.add(myNode, i, j);
                //if(pieceNode != null) bloco = new Group(pieceNode, myNode);
                //else bloco = new Group(myNode);
                //gridPane.add(myNode, i, j);
                //pieceNode = null;
                pieceImage = null;
            }
        }
    }
    
    public Pane makeBloco(boolean white, Image pieceImg) {
        Pane bloco = new Pane();
        ImageView g;
        g = white == true ? new ImageView(whiteBlock) : new ImageView(blackBlock);
        bloco.getChildren().add(g);
        if(pieceImg != null) {
            ImageView p1 = new ImageView(pieceImg);
            p1.setLayoutX(2.5);
            p1.setLayoutY(-75);
            System.out.println("Add image");
            bloco.getChildren().add(p1);
        }
         
        return bloco;
    }
    
    public void OnBlockSelected() {
        
        if(tab.getBlock(selectedVector).isEmpty()) {
            System.out.println("Onde voce clicou não há peça");
        } else {
            System.out.println("Voce encontrou uma peça! Aqui estão as possíveis movimentações dela:");
            tab.getBlock(selectedVector).getPiece().checkMove(tab);
            possibleBlocks = tab.getBlock(selectedVector).getPiece().getFreeWay();
        }
    }
    
}
