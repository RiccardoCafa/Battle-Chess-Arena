package Sounds;

import businessPack.TypeHero;
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
       tockers.setMute(true);
    } 
    
    public void playMusic(int indexMusic){
        
        tockers.stop();
        tockers = new MediaPlayer(exaltaSamba.get(indexMusic));
        tockers.setStartTime(Duration.ZERO);
         tockers.play();
    }
    
    public void playMusic(TypeHero hero){
        int indexMusic = transfromHeroToIndex(hero);
        tockers.stop();
        tockers = new MediaPlayer(exaltaSamba.get(indexMusic));
        tockers.setStartTime(Duration.ZERO);
         tockers.play();
    }
    
    private int transfromHeroToIndex(TypeHero hero) {
        switch(hero){
            case huebr:   return 0;
            case lapa:    return 1;
            case lenin:   return 2;
            case wizard:  return 3;
            case sheriff: return 4;
        }
        return 0;
    }
    
    public void stopMusic() {
        tockers.stop();
    }
    /*
    * 
    * @param volume tem que ser entre 0 e 1;
    */
    public void volumeChange(double volume) {
        tockers.setVolume(volume);
    }

}
