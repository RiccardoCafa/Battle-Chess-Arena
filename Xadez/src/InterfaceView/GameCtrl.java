package InterfaceView;

import businessPack.Heros.Huebr;
import businessPack.Heros.Lapa;
import businessPack.Heros.Wizard;
import businessPack.Player;
import businessPack.Players;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
import javafx.scene.text.Text;

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
    Button btnSuperPower;
    @FXML
    TextArea gameplayChat;
    @FXML
    Button PassTurn;
    @FXML
    Text season;
    
    String gameName = "System";
    
    Player p1, p2;
    
    GameManager gameManager;
    
    public void gameCtrl(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        gameManager = new GameManager(p1, p2, this);
        gameManager.GameInit();
        gameplayChat.appendText("[" + gameName + "] Bem-vindo ao Battle Chess Arena!\n");
        gameplayChat.appendText("[" + gameName + "] Os exércitos foram montados.\n");
        gameplayChat.appendText("[" + gameName + "] Que os jogos comecem!\n");
        persoImage.setImage(Players.getActualPlayer().getHero().getImage());
        superPowerBtnManager();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setBackground(new Background( new BackgroundImage(new Image("InterfaceView/imagens/fundoJogo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }
    
    public void addToGrid(Node nodeToAdd, int i, int j) {
        gridPane.add(nodeToAdd, i, j);
    }
    
    public void addToPiecesPane(Node nodeToAdd) {
        pratoPieces.getChildren().add(nodeToAdd);
    }
    
    public ImageView makeBlock(int i, int j) {
        // Pega um bloco do table, cria um evento pra ele e o add no gridpane
        ImageView g;
        g = gameManager.getTable().getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            //if(e.isPrimaryButtonDown())
                gameManager.OnBlockClicked(e);
        });
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            //if(e.isSecondaryButtonDown())
                gameManager.OnBlockEnter(e);
        });
        return g;

    }   
    
    public void superPowerBtnManager() {
        if(Players.getActualPlayer().getHero() instanceof Lapa ||
                Players.getActualPlayer().getHero() instanceof Huebr) {
            btnSuperPower.setVisible(true);
        } else { 
            btnSuperPower.setVisible(false);
        }
        if(Players.getActualPlayer().getHero() instanceof Wizard) {
            Wizard wiz = (Wizard) Players.getActualPlayer().getHero();
            if(!wiz.isWallSetted() || wiz.getCanMove()) {
            // Sou virgem ainda
                btnSuperPower.setVisible(true);
            } else {
                btnSuperPower.setVisible(false);
            }
        }
        persoImage.setImage(Players.getActualPlayer().getHero().getImage());
        gameplayChat.appendText("[" + gameName + "] Vez de " + Players.getActualPlayer().getName() + "\n");
    }
    
    @FXML
    public void OnBtnPower(MouseEvent e) {
        gameManager.SuperPowerBtn();
    }
    
    public void displayMessage(String sender, String message) {
        gameplayChat.appendText("[" + sender + "] " + message + "\n");
    }
    
    public void PassTurnOnClick(MouseEvent e){
        gameManager.EndOfTurn();
    }
}
