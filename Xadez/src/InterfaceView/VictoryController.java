package InterfaceView;

import Sounds.HeroesMusics;
import businessPack.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class VictoryController implements Initializable {

    @FXML
    Label playerName;
    @FXML
    ImageView playerHero;
    @FXML
    AnchorPane back;
    
    HeroesMusics heroMusics = new HeroesMusics();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setPlayerVictorious(Player player) {
        playerName.setText(player.getName());
        int width = 375;
        int height = 330;
        playerHero.setImage(player.getHero().getImageIcon(375, 330));
        heroMusics.playMusic(player.getHero().getHeroType());
    }
    
    @FXML
    public void onPlayAgain() {
        Stage primary = (Stage) back.getScene().getWindow();
        try{
            System.out.println("loading");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseCharacter.fxml"));
            Parent rooter = loader.load();
//            GameCtrl gameCtrl = loader.getController();
//            gameCtrl.gameCtrl(p1, p2);
            Scene eltonJhon = new Scene(rooter);
            Stage stage = new Stage();
            
            stage.setTitle("Battle Chess Arena!");
            stage.setScene(eltonJhon);
            stage.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
            e.printStackTrace();
        }
        primary.close();
    }
}
