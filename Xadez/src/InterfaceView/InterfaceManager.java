package InterfaceView;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author falca
 */
public class InterfaceManager extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        
        WindowConfig();
    }
    
    public void WindowConfig() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InterfaceManager.class.getResource("Menu.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        launch(args);
    }
    /*
    Esse vai gerenciar as instancias de interface do jogo
    1. Tela de login inicialmente
        1.1 Start
        1.2 Opções
        1.3 Créditos
    2. Lobby
    3. Game
    */
}
