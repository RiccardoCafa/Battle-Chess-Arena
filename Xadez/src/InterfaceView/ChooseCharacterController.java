package InterfaceView;

import businessPack.Heros.Huebr;
import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Player;
import static businessPack.TypeHero.huebr;
import static businessPack.TypeHero.lapa;
import static businessPack.TypeHero.lenin;
import static businessPack.TypeHero.sheriff;
import static businessPack.TypeHero.wizard;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import Sounds.HeroesMusics;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;


//String musicURL = "src/testemedia/dancing.mp3";
//Media media = new Media(getClass().getResource("dancing.mp3").toString());
//MediaPlayer starter = new MediaPlayer(media);

public class ChooseCharacterController implements Initializable {
    
    ArrayList<MediaPlayer> musicas = new ArrayList<>();  
    MediaPlayer musicaAtual;
    
    @FXML
    ImageView characterSelection;
    @FXML
    Text heroName;
    @FXML
    AnchorPane background;
    @FXML
    TextField names1;
    @FXML
    Text PlayerName1;
    @FXML
    Text PlayerName2;
    @FXML
    Text HeroPlayer1;
    @FXML
    Text HeroPlayer2;
    @FXML
    ImageView hero1;
    @FXML
    ImageView hero2;
    @FXML
    ImageView hero3;
    @FXML
    ImageView hero4;
    @FXML
    ImageView hero5;
    @FXML
    TextArea infoText;
    @FXML
    Pane back;
    
    private Stage primaryStage;
    Image myImage;
    ImageView myImageView;
    int count = 0,cont = 0;
    int countAnt = -1;
    Image[] perso = new Image[5];
    String[] heroNames = new String[5];
    Player p1,p2;
    String name1 = "player1",name2 = "player2";
    private int infoType = 1;


    private HeroesMusics music = new HeroesMusics();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // TODO
        back.setBackground(new Background( new BackgroundImage(new Image("InterfaceView/imagens/fundoVazio.png", 1186, 667, false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        int resX = 350;
        int resY = 350;
        perso[0] = new Image("InterfaceView/Personagens/iconeHueBR.png",resX, resY, false, false);
        heroNames[0] = "Huehue br";
        perso[1] = new Image("InterfaceView/Personagens/iconeLapa.png",resX, resY, false, false);
        heroNames[1] = "Lapa";
        perso[2] = new Image("InterfaceView/Personagens/iconeLenin.png",resX, resY, false, false);
        heroNames[2] = "Czar Nicolau II";
        perso[3] = new Image("InterfaceView/Personagens/iconeWizard.png", resX, resY, false, false);
        heroNames[3] = "The Wizard";
        perso[4] = new Image("InterfaceView/Personagens/iconeSheriff.png",resX, resY, false, false);
        heroNames[4] = "Gunslinger";
        myImage = new Image("InterfaceView/setaesq.png");
        myImageView = new ImageView(myImage);
        //setaEsq.setGraphic(myImageView);
        myImage = new Image("InterfaceView/setadir.png");
        myImageView = new ImageView(myImage);
        //setaDir.setGraphic(myImageView);
        
        hero1.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            count = 0;
            updateCharacterInfo();
        });
        
        hero2.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            count = 1;
            updateCharacterInfo();
        });
        
        hero3.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            count = 2;
            updateCharacterInfo();
        });
        
        hero4.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            count = 3;
            updateCharacterInfo();
        });
        
        hero5.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            count = 4;
            updateCharacterInfo();
        });

        characterSelection.setImage(perso[count]);
        music.playMusic(count);
        
    }

    public void updateCharacterInfo() {
        heroName.setText(heroNames[count]);
        characterSelection.setImage(perso[count]);
        music.playMusic(count);
        updateInfoText();
    }
    
    public void updateInfoText() {
        infoText.setText("");
        switch(count) {
               
            case 0:
                switch (infoType) {
                    case 1:
                        infoText.appendText(Huebr.description);
                        break;
                    case 2:
                        infoText.appendText(Huebr.skills);
                        break;
                    default:
                        infoText.appendText(Huebr.movimentos);
                        break;
                }
                break;
            case 1:
                switch (infoType) {
                    case 1:
                        infoText.appendText(Lapa.description);
                        break;
                    case 2:
                        infoText.appendText(Lapa.skills);
                        break;
                    default:
                        infoText.appendText(Lapa.movimentos);
                        break;
                }
            default:
                
                break;
        }
    }
    
    @FXML
    public void onSkillsInfoClick(MouseEvent e) {
        infoType = 2;
        updateInfoText();
    }
    
    @FXML
    public void onDescrInfoClick(MouseEvent e) {
        infoType = 1;
        updateInfoText();
    }
    
    @FXML
    public void onPieceInfoClick(MouseEvent e) {
        infoType = 3;
        updateInfoText();
    }
    
    @FXML
    public void onClickButton(MouseEvent e){
        
        if(countAnt == count) {
            JOptionPane.showMessageDialog(null, "Esse personagem já foi selecionado!");
            return;
        }
        
        if(!setName()) {
            JOptionPane.showMessageDialog(null, "Nomes iguais!");
            return;
        }
        
        switch(count){
            case 0:
                //name = "Hue";
                if(p1 != null){
                        p2 = new Player(-1, new Huebr(), 2,name2);
                        HeroPlayer2.setText("Huebr");
                }else{
                    p1 = new Player(1, new Huebr(), 1, name1);
                    HeroPlayer1.setText("Huebr");
                } 
                break;
            case 1:
                //name = "Lapa";
                   if(p1 != null){
                        p2 = new Player(-1, new Lapa(), 2,name2);
                        HeroPlayer2.setText("Lapa");
                }else{
                     p1 = new Player(1, new Lapa(), 1, name1);
                     HeroPlayer1.setText("Lapa");
                } 
                break;
            case 2:
                //name = "Czar";
                   if(p1 != null){
                            p2 = new Player(-1, new Lenin(), 2,name2);
                            HeroPlayer2.setText("Lenin");
                }else{
                         p1 = new Player(1, new Lenin(), 1, name1);
                         HeroPlayer1.setText("Lenin");
                } 
                break;
            case 3:
                //name = "Mago"; 
                if(p1 != null){
                        p2 = new Player(-1, new Wizard(), 2,name2);
                        HeroPlayer2.setText("Wizard");
                }else{
                        p1 = new Player(1, new Wizard(), 1, name1);
                        HeroPlayer1.setText("Wizard");
                } 
                break;
            case 4:
                //name = "Pistoleiro";
                   if(p1 != null){
                        p2 = new Player(-1, new Sheriff(), 2,name2);
                        HeroPlayer2.setText("Sheriff");
                }else{
                        p1 = new Player(1, new Sheriff(), 1, name1);
                        HeroPlayer1.setText("Sheriff");
                } 
                break;
        }
        countAnt = count;
        count++;
        if(count > 4) count = 0;
        updateCharacterInfo();
        names1.setText("");
        //funcao para pegar o player

        if(p1 != null && p2 != null){
            primaryStage = (Stage) background.getScene().getWindow();
            music.stopMusic();
            LoadScene("Game8x8.fxml");
            primaryStage.close();   
        }
    }

    public boolean setName() {
        if(cont == 0){
            if(!names1.getText().equals("")){
              name1 = names1.getText();
              PlayerName1.setText(name1);
            }
            cont++;
        }else{
            if(!names1.getText().equals("")){
                name2 = names1.getText();
                if(name1.compareToIgnoreCase(name2) == 0) {
                    return false;
                }
                PlayerName2.setText(name2);
            }
        }
        return true;
    }
    private void LoadScene(String sceneName){
        try{
            System.out.println("loading");
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName));
            Parent rooter = loader.load();
            GameCtrl gameCtrl = loader.getController();
            gameCtrl.gameCtrl(p1, p2);
            Scene eltonJhon = new Scene(rooter);
            Stage stage = new Stage();
            
            stage.setTitle("Choose Your Character!");
            stage.setScene(eltonJhon);
            stage.show();
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela");
            System.out.println("Nao foi possível abrir a janela");
            e.printStackTrace();
        }
    }
    @FXML
    public void onSetaClickEsq(MouseEvent event) {
        //musicaAtual.stop();
        //music.playMusic(count);
        if(count == 0){
            count = 4;
        }else{
            count--;
        }
        heroName.setText(heroNames[count]);
        characterSelection.setImage(perso[count]);

        if(countAnt == count) {
            count--;
            if(count<0) count = 4;
        }
        music.playMusic(count);
        updateCharacterInfo();

    }
    @FXML
    public void onSetaClickDir(MouseEvent event){
        //music.playMusic(count);
        if(count == 4){
            count = 0;
        }else{
            count++;
        }
        if(countAnt == count) {
            count++;
            if(count > 4) count = 0;
        }
        updateCharacterInfo();
        music.playMusic(count);
//        musicaAtual = musicas.get(count);
//        musicaAtual.setStartTime(Duration.ZERO);
//        musicaAtual.isAutoPlay();
//        musicaAtual.play();

//        heroName.setText(heroNames[count]);

        
    }

}
