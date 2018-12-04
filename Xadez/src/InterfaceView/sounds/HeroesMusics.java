package InterfaceView.sounds;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;




// esta classe foi criada por Lucas Souza e Felipe Stamoglou,pau no cu de quem reclamar
//beijão
public class HeroesMusics {
   
    private ArrayList<Media> exaltaSamba = new ArrayList<Media>();
    
    
    
    public void setMusicsON(){
       //medias a serem tocadas
        System.out.println("null pointer?");
       Media hue3 = new Media(getClass().getResource("MUSICA_HUE_HUE_BR.mp3").toString());
       Media Lapa = new Media(getClass().getResource("Lapa.mp3").toString());
       Media Lenin = new Media(getClass().getResource("Lenin.mp3").toString()); 
       Media Mago = new Media(getClass().getResource("Wizard.mp3").toString()); 
       Media Sheriff = new Media(getClass().getResource("Sheriff.mp3").toString());

       exaltaSamba.add(hue3);//index = 0
       exaltaSamba.add(Lapa);//index = 1
       exaltaSamba.add(Lenin);//index = 2
       exaltaSamba.add(Mago);//index = 3
       exaltaSamba.add(Sheriff);//index = 4


    } 
    
    public void playMusic(int indexMusic){
        
        System.out.println("Null pointer?");
        MediaPlayer tockers = new MediaPlayer(exaltaSamba.get(indexMusic));   
        
        tockers.setStartTime(Duration.ZERO);
        tockers.play();
        
    }
    
    




    
}
