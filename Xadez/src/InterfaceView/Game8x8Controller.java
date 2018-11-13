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
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1 = new Player(1, new Lapa(null), 1);
        player1 = new Player(1, new Sheriff(null), 2);
        tab = new Table(8, 8, player1, player2);
        Tower t = new Tower(PlayerPiece.Player1, TypeHero.lapa, 2, 3, new LapaTower(player1));
        tab.getTable()[2][3] = new Block(t, 2, 3);
        MountArmyOnTable(tab);
    }    
    
    @FXML
    public void gridOnClick(MouseEvent e) {
        /*Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.println(e.getSource() instanceof Node);
        System.out.println(e.getSource() instanceof Node ? e.getSource().getClass().getName() : "null");
        System.out.println(colIndex + " " + rowIndex);*/
    }
    
    public void MountArmyOnTable(Table tab) {
        Node myNode;
        Image whiteBlock = new Image("InterfaceView/blocoBranco.png", 62, 62, false, false );
        Image blackBlock = new Image("InterfaceView/blocoPreto.png", 62, 62, false, false );
        
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if((i%2==0 && j%2==0) || (j%2!=0 && i%2!=0)) {
                    myNode = new ImageView(whiteBlock);
                } else {
                    myNode = new ImageView(blackBlock);
                }
                myNode.setOnMouseReleased((MouseEvent e) -> {
                    if(!movingPiece) {
                        Node myBlock = (Node) e.getSource();
                        selectedVector = new Vetor(GridPane.getColumnIndex(myBlock), GridPane.getRowIndex(myBlock));
                        OnBlockSelected();
                        movingPiece = true;
                    } else {
                        //Checar se a peça que ele clicou é uma peça possível
                    }
                });
                gridPane.add(myNode, i, j);
            }
        }
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
