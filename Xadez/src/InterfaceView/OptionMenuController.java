package InterfaceView;

import Sounds.HeroesMusics;
import businessPack.MultiLanguage;
import businessPack.TempSaver;
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
import javafx.scene.control.Label;
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
    @FXML
    Label langText;
    private Stage primaryStage;
    private File optionFile;
    private TempSaver saver;
    private String sceneCall;
    private HeroesMusics musica;
    private Runnable gameControl;
    private boolean running = true;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saver = new TempSaver();
        //optionFile = saver.makeFile("Options.txt");
        String valueS = saver.readOnFile("Options", "Volume");
        String langCh = saver.readOnFile("Language", "Lang");
        if(langCh != null && langCh.equals("en")) {
            langText.setText("English");
        } else {
            langText.setText("Português");
        }
        if(valueS != null) { 
            double value = Double.parseDouble(valueS);
            volumeSlider.setValue(value);
        } else {
            volumeSlider.setValue(1);
        }
    }
    @FXML
    public void onOptionsSave() {
//        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        int resp = JOptionPane.showConfirmDialog(null, "Deseja confirmar?", "Salvar alterações", JOptionPane.YES_NO_OPTION);
        if(resp == 0) {
            setLangPref(MultiLanguage.lang);
            saver.writeOnFile("Options", "Volume", Double.toString(volumeSlider.getValue()));
            BackToScene();
        } else if(resp == 1) {
            BackToScene();
        }
    }
    @FXML
    public void onBackClick(MouseEvent e){
        BackToScene();
    }
    @FXML
    public void setEnLang() {
        MultiLanguage.setLang("en");
        langText.setText("English");
        
    }
    @FXML
    public void setPtLang() {
        MultiLanguage.setLang("pt");
        langText.setText("Português");
        
    }
    public void setLangPref(String langPref) {
        saver.writeOnFile("Language", "Lang", langPref);
    }
    private void BackToScene(){
        primaryStage = (Stage) rootPane.getScene().getWindow();
        if(musica!=null) musica.updateVolumeBySave();
        running = false;
        if(sceneCall.equals("none")) {
            primaryStage.close();
            return;
        }
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneCall));
            Parent root1 = (Parent) loader.load();
            Stage aroldo = new Stage();
            aroldo.setTitle("Choose Your Character!");
            aroldo.setScene(new Scene(root1));
            aroldo.show();
        } catch(IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a janela, por favor, reporte isso para podermos melhorar!");
        }
        primaryStage.close();
    }
    public void SetSceneCallBack(String sceneCall) {
        this.sceneCall = sceneCall;
    }
    public void SetMusicPlayer(HeroesMusics musica) {
        this.musica = musica;
        gameControl = new Runnable() {
            @Override
            public void run() {
                while(running) {
                    if(musica==null) running = false;
                    if(volumeSlider == null) running = false;
                    musica.setVolume(volumeSlider.getValue()/100);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Something happen");
                    }
                }
            }
        };
        Thread tControl = new Thread(gameControl);
        tControl.start();
    }
}
