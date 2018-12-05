package Sounds;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;




public class HeroesMusics {
   
    private ArrayList<Media> exaltaSamba = new ArrayList<>();
    MediaPlayer tockers;
    
    public HeroesMusics(){
       //medias a serem tocadas
       Media hue3 = new Media(getClass().getResource("MUSICA HUE HUE BR.mp3").toString());
       Media Lapa = new Media(getClass().getResource("Lapa.mp3").toString());
       Media Lenin = new Media(getClass().getResource("Lenin.mp3").toString()); 
       Media Mago = new Media(getClass().getResource("Mago.mp3").toString()); 
       Media Sheriff = new Media(getClass().getResource("Sheriff.mp3").toString());

       exaltaSamba.add(hue3);//index = 0
       exaltaSamba.add(Lapa);//index = 1
       exaltaSamba.add(Lenin);//index = 2
       exaltaSamba.add(Mago);//index = 3
       exaltaSamba.add(Sheriff);//index = 4
       tockers = new MediaPlayer(exaltaSamba.get(0));
    } 
    
    public void playMusic(int indexMusic){
        
        tockers.stop();
        tockers = new MediaPlayer(exaltaSamba.get(indexMusic));
        tockers.setStartTime(Duration.ZERO);
        tockers.play();
    }
    
    public void stopMusic() {
        tockers.stop();
    }
}
