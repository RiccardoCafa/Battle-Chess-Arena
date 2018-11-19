package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Lenin.LeninKing;
import businessPack.Pieces.Queen;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class GameCtrl implements Initializable {

    @FXML
    GridPane gridPane;
    @FXML
    AnchorPane background;
    @FXML
    ImageView persoImage;
    
    Vetor myVector;
    Vetor selectedVector;
    
    ArrayList<Block> possibleBlocks;
    
    boolean movingPiece = false;
    
    Table table;
    
    Player player1;
    Player player2;
    Player playing;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setBackground(new Background( new BackgroundImage(new Image("InterfaceView/imagens/fundoJogo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        /*player1 = new Player(-1, new Lenin(), 1);
        player2 = new Player(1, new Lapa(), 2);
        Players.setPlayer1(player1);
        Players.setPlayer2(player2);
        playing = player1;
        table = new Table(8, 8, player1, player2);
        Bishop c = new Bishop(player2.getWho(), TypeHero.lenin, 4, 4);
        King  k = new  King(player1.getWho(), TypeHero.lapa, 1, 0);
        King kL = new  King(player1.getWho(), TypeHero.lapa, 4, 2);
        Queen q = new Queen(player1.getWho(), TypeHero.lapa, 5, 0);
        Tower t = new Tower(player1.getWho(), TypeHero.lapa, 2, 3);
        Horse h = new Horse(player2.getWho(), TypeHero.lenin, 6, 4);
        table.getTable()[2][3].setPiece(t);
        table.getTable()[1][0].setPiece(k);
        table.getTable()[4][2].setPiece(kL);
        table.getTable()[5][0].setPiece(q);
        table.getTable()[4][4].setPiece(c);
        table.getTable()[6][4].setPiece(h);*/
        player1 = new Player(-1, new Sheriff(), 1);
        player2 = new Player(1, new Lapa(), 2);
        Players ps = new Players(player1, player2);
        //Players.setPlayer1(player1);
        //Players.setPlayer2(player2);
        playing = player1;
        table = new Table(8, 8, player1, null);
        
        MountArmyOnTable(table);
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                table.getBlock(i, j).setPiece(player1.getArmy().findPiece(i, j));
                //table.getTable()[i][j].setPiece(player2.getArmy().findPiece(i, j));
            }
        }
        //MoveImage(new Vetor(2, 3), new Vetor(5, 5));
    }
    public void MountArmyOnTable(Table tab) {
        ImageView pieceImage = null;
        
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if(!tab.getBlock(i, j).isEmpty()) {
                    pieceImage = tab.getBlock(i, j).getPiece();
                }
                gridPane.add(makeBloco(i, j, pieceImage), i, j);  
                pieceImage = null;
            }
        }
    }
    
    public Pane makeBloco(int i, int j, ImageView pieceImg) {
        Pane bloco = new Pane();
        ImageView g;
        g = table.getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            OnPieceClicked(e);
        });
        
        //g = white == true ? new ImageView(whiteBlock) : new ImageView(blackBlock);
        bloco.getChildren().add(g);
        if(pieceImg != null) {
            bloco.getChildren().add(pieceImg);
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
                myBlock.getPiece().checkMove(table);
                possibleBlocks = myBlock.getPiece().getFreeWay();
                showPossibleWays(possibleBlocks);
                showPossibleEnemys(myBlock.getPiece().getHitWay(), myBlock.getPiece().getPlayer());
                System.out.println("Selected Piece");
            } else {
                System.out.println("Nothing here");
            }
        } else {
            if(myBlock.isEmpty() && possibleBlocks.contains(myBlock)) {
                Vetor novaPos = new Vetor(myBlock.getVetor());
                MoveImage(selectedVector, novaPos);
                table.MovePiece(selectedVector, novaPos);
                table.getBlock(selectedVector).colorDefault();
                movingPiece = false;
                resetBlockTab();
                System.out.println("Moved Piece");
            } else if(myBlock.getVetor() == selectedVector){
                movingPiece = false;
                resetBlockTab();
            }
        }
    }
    
    public void MoveImage(Vetor source, Vetor dest) {
        ObservableList<Node> childrens = gridPane.getChildren();
        Pane myPane= null;
        Pane destPane = null;
        PathTransition animate = new PathTransition();
        animate.setDuration(Duration.seconds(2));
        Line line = new Line(source.getX(), source.getY(), dest.getX(), dest.getY());
        animate.setPath(line);
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
        animate.setNode(myPane.getChildren().get(1));
        Node tempPane = myPane.getChildren().get(1);
        animate.play();
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