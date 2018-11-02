/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author falca
 */
public class ChooseCharacterController implements Initializable {

    @FXML
    Button setaEsq;
    @FXML
    Button setaDir;
    @FXML
    Button characterSelection;
    Image myImage;
    ImageView myImageView;
    int count = 0;
    Image[] perso = new Image[5];
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        perso[0] = new Image("");
        perso[1] = new Image("");
        perso[2] = new Image("");
        perso[3] = new Image("");
        perso[4] = new Image("");
        myImage = new Image("Imagens/Setas/setaesq.png");
        myImageView = new ImageView(myImage);
        setaEsq.setGraphic(myImageView);
        myImage = new Image("Imagens/Setas/setadir.png");
        myImageView = new ImageView(myImage);
        setaDir.setGraphic(myImageView);
        characterSelection.setGraphic(new ImageView(perso[0]));
        
    }
      @FXML
    public void onSetaClickEsq(MouseEvent event) {
        if(count == 0){
            count = 4;
        }else{
            count--;
        }
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    @FXML
    public void onSetaClickDir(MouseEvent event){
        if(count == 4){
            count = 0;
        }else{
            count++;
        }
        characterSelection.setGraphic(new ImageView(perso[count]));
    }
    
    
}
