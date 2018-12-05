package InterfaceView;

import businessPack.Saver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class OptionMenuController implements Initializable {
    @FXML
    Button QuitBtn;
    @FXML
    AnchorPane rootPane;
    @FXML
    Slider volumeSlider;
    @FXML
    Button SaveBtn;
    private Stage primaryStage;
    private File optionFile;
    private File gameFolder;
    private Saver saver;
    private String optionKey = "Option";
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saver = new Saver();
        saver.makeFile(optionKey, "Options.txt");
    }
    @FXML
    public void onOptionsSave() {
            saver.writeOnFile(optionKey, "Volume", Double.toString(volumeSlider.getValue()));
            JOptionPane.showMessageDialog(null, "Suas configurações foram salvas!");
    }
    @FXML
    public void onBackClick(MouseEvent e){
        primaryStage = (Stage) rootPane.getScene().getWindow();
        LoadScene("Menu.fxml");
        primaryStage.close();
    }
     private void LoadScene(String scene){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
            Parent root1 = (Parent) loader.load();
            Stage aroldo = new Stage();
            aroldo.setTitle("Choose Your Character!");
            aroldo.setScene(new Scene(root1));
            aroldo.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
        }
    }
}
