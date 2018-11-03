/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MenuController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    Button StartBtn;
    @FXML
    Button OptionBtn;
    @FXML
    Button QuitBtn;
    ChooseCharacterController choose;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    public void onPlayClick(MouseEvent e) throws IOException{
        LoadScene("ChooseCharacter");
    }
    @FXML
    public void onCloseClick(MouseEvent e){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
    private void LoadScene(String scene){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource(scene+".Fxml"));
        }catch( IOException ex){
            //n sei oque colocar aqui
            
        }
    }
}
