package InterfaceView;

import businessPack.TempSaver;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class MenuController implements Initializable {
    @FXML
    ImageView StartBtn;
    @FXML
    ImageView OptionBtn;
    @FXML
    ImageView QuitBtn;
    @FXML
    AnchorPane background;
    
    private Stage primaryStage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        background.setBackground(new Background( new BackgroundImage(new Image("InterfaceView/imagens/telaInicial.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        String btnPath = "InterfaceView/imagens/buttons/";
        StartBtn.setImage(new Image(btnPath + "JogarButton.png"));
        QuitBtn.setImage(new Image(btnPath + "sairButton.png"));
    }
    
    @FXML
    public void onPlayClick(MouseEvent e) throws IOException{
        primaryStage = (Stage) background.getScene().getWindow();
        LoadScene("ChooseCharacter.fxml");
        primaryStage.close();
    }
    @FXML
    public void OnOptionClick(MouseEvent e){
        primaryStage = (Stage) background.getScene().getWindow();
        LoadScene("OptionMenu.fxml");
        primaryStage.close();        
    }
    @FXML
    public void onCloseClick(MouseEvent e){
        Stage stage = (Stage) background.getScene().getWindow();
        stage.close();
    }
    private void LoadScene(String sceneName){
        try{
            System.out.println("loading");
            Parent loader = FXMLLoader.load(getClass().getResource(sceneName));
            //Parent root1 = (Parent) loader.load();
            Scene johnCena = new Scene(loader);
            Stage stage = new Stage();
            stage.setTitle("Choose Your Character!");
            stage.getIcons().add(new Image("InterfaceView/imagens/iconGameAlpha.png", 500, 500, false, false));
            stage.setScene(johnCena);
            stage.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
            e.printStackTrace();
        }
    }

    public void WindowConfig() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InterfaceManager.class.getResource("Menu.fxml"));
            background = (AnchorPane) loader.load();
            
            Scene scene = new Scene(background);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    
}
