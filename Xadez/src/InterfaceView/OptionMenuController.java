package InterfaceView;

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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new File(System.getProperty("java.io.tmpdir") + "BattleChessArena").mkdir();
        String tempPath = System.getProperty("java.io.tmpdir") + "/BattleChessArena";
        System.out.println(tempPath);
        optionFile = new File(tempPath, "options.txt");
    }
    @FXML
    public void onOptionsSave() {
        
        try {
            //if(optionFile.exists()) {
            FileWriter escrevedor = new FileWriter(optionFile);
            escrevedor.write("Volume " + volumeSlider.getValue());
            JOptionPane.showMessageDialog(null, "Configurações salvas!");
            escrevedor.close();

        } catch (IOException ex) {
            Logger.getLogger(OptionMenuController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
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
