package InterfaceView;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceMain extends Application {

    //private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootLayout = FXMLLoader.load(getClass().getResource("ChooseCharacter.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setTitle("Battle Chess Arena Login!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
