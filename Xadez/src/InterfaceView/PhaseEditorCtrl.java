package InterfaceView;

import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Piece;
import businessPack.Player;
import businessPack.Table;
import static extras.Who.player1;
import static extras.Who.player2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PhaseEditorCtrl implements Initializable {

    @FXML
    TextField nameInput;
    @FXML
    ImageView p1Image;
    @FXML
    ImageView p2Image;
    @FXML
    Slider p1Slider;
    @FXML
    Slider p2Slider;
    @FXML
    GridPane tabGrid;
    @FXML
    ImageView peonImg;
    @FXML
    ImageView horseImg;
    @FXML
    ImageView bishopImg;
    @FXML
    ImageView kingImg;
    @FXML
    ImageView queenImg;
    @FXML
    ImageView towerImg;
    @FXML
    Button saveBtn;
    @FXML
    Pane piecesPane;
    @FXML
    Toggle cheatsOn;
    
    Image[] heroImages = new Image[5]; 
    ImageView[] piecesImg = new ImageView[6];
    String phaseName;
    Table table;
    int[][] tableToSave = new int[8][8];
    ImageView[][] piecesTable = new ImageView[8][8];
    ImageView selectedPiece;
    //Thread heroChange = new Thread("HeroChanging");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int width = 60, heigth = 50;
        heroImages[0] = new Image("InterfaceView/Personagens/huehuebr-01.png", width, heigth, false, false);
        heroImages[1] = new Image("InterfaceView/Personagens/lapa-01.png", width, heigth, false, false);
        heroImages[2] = new Image("InterfaceView/Personagens/lenin-01.png", width, heigth, false, false);
        heroImages[3] = new Image("InterfaceView/Personagens/omago-01.png", width, heigth, false, false);
        heroImages[4] = new Image("InterfaceView/Personagens/pistoleiro-01.png", width, heigth, false, false);
        
        piecesImg[0] = peonImg;
        piecesImg[1] = towerImg;
        piecesImg[2] = horseImg;
        piecesImg[3] = bishopImg;
        piecesImg[4] = queenImg;
        piecesImg[5] = kingImg;
        Player player1 = new Player(-1, new Lapa(), 1, "Riccardao");
        Player player2 = new Player(1, new Lenin(), 2, "xXPlayer2Xx");
        table = new Table(8, 8, player1, player2);
        
        p1Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                p1Image.setImage(heroImages[(int)p1Slider.getValue() - 1]);
            }
        });
        
        p2Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                p2Image.setImage(heroImages[(int)p2Slider.getValue() - 1]);
            }
        });
        
        saveBtn.addEventHandler(ActionEvent.ANY, (ActionEvent e) -> {
            try {
                String tempPath = System.getProperty("java.io.tmpdir");
                File fase = new File(tempPath, nameInput.getText() + ".txt");
                FileWriter fw = new FileWriter(fase);
                fw.write((int) p1Slider.getValue() + " " + (int)p2Slider.getValue());
                System.out.println(fase.getCanonicalPath());
                fw.close();
            } catch(IOException es) {
                es.printStackTrace();
            } 
            
        });
        
        for(ImageView img : piecesImg) {
            img.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
                selectedPiece = img;
            });
        }
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tabGrid.add(makeBlock(i, j), i, j);
            }
        }
    }    
    
    public ImageView makeBlock(int i, int j) {
        ImageView g;
        g = table.getBlock(i, j);
        g.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e)->{
            if(e.getButton() == MouseButton.SECONDARY) {
                if(selectedPiece != null) {
                    ImageView s = new ImageView(selectedPiece.getImage());
                    s.setVisible(false);
                    piecesPane.getChildren().add(s);

                }
            }
        });
        piecesTable[i][j] = g;
        return g;
    }
    
}
