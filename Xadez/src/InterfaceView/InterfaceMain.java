package InterfaceView;

import businessPack.MultiLanguage;
import businessPack.TempSaver;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class InterfaceMain extends Application {

    //private Stage primaryStage;
    private Image gameIcone = new Image("InterfaceView/imagens/iconGameAlpha.png");
    @Override
    public void start(Stage primaryStage) {
        
        Parent rootLayout = null;
        try {
            rootLayout = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Battle Chess Arena Login!");
            primaryStage.getIcons().add(gameIcone);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
