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


public class OptionMenuController implements Initializable {
    @FXML
    Button Back;
    @FXML
    AnchorPane Pane;
    private Stage primaryStage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    @FXML
    public void onBackClick(MouseEvent e){
        primaryStage = (Stage) Pane.getScene().getWindow();
        LoadScene("Menu.fxml");
        primaryStage.close();
    }
     private void LoadScene(String scene){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Choose Your Character!");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
            e.printStackTrace();
        }
    }
}
