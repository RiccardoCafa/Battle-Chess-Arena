package InterfaceView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class MenuController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    Button StartBtn;
    @FXML
    Button OptionBtn;
    @FXML
    Button QuitBtn;
    
    private Stage primaryStage;
    
    @FXML
    public void onPlayClick(MouseEvent e) throws IOException{
        LoadScene("ChooseCharacter");
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void onCloseClick(MouseEvent e){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
    
    private void LoadScene(String scene){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseCharacter.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Choose Your Character!");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
        }
    }

    public void WindowConfig() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InterfaceManager.class.getResource("Menu.fxml"));
            rootPane = (AnchorPane) loader.load();
            
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
