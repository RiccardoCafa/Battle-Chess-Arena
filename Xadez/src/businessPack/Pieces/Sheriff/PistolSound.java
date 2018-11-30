package businessPack.Pieces.Sheriff;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PistolSound {
    //atributos>>
    Media rec = new Media(getClass().getResource("rechargeSound.mp3").toString());
    Media shoot = new Media(getClass().getResource("shootSound.mp3").toString());
    MediaPlayer shootSound = new MediaPlayer(shoot);
    MediaPlayer recharge = new MediaPlayer(rec);
    
    //metodos>>
    public void playRechargeSound(){ recharge.play(); }
    public void playShootSound(){ shootSound.play(); }
}