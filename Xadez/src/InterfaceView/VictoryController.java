package InterfaceView;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setPlayerVictorious(Player player) {
        playerName.setText(player.getName());
        int width = 375;
        int height = 330;
        // TODO MELHORAR ESSE SWITCH AQUI DEPOIS (00:26 TO CANSADO) (COLOCAR UMA FUNCAO PADRAO, JA CHAMAMOS UMAS 3x KKKKKK CADE O RE USO DE CODIGO GENTE)
        switch(player.getHero().getHeroType()) {
            case lapa: playerHero.setImage(new Image("InterfaceView/Personagens/iconeLapa.png", width, height, false, false));
                break;
            case huebr: playerHero.setImage(new Image("InterfaceView/Personagens/iconeHueBR.png", width, height, false, false));
                break;
            case lenin: playerHero.setImage(new Image("InterfaceView/Personagens/iconeLenin.png", width, height, false, false));
                break;
            case sheriff: playerHero.setImage(new Image("InterfaceView/Personagens/iconeSheriff.png", width, height, false, false));
                break;
            case wizard: playerHero.setImage(new Image("InterfaceView/Personagens/iconeWizard.png", width, height, false, false));
                break;
        }
        
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
