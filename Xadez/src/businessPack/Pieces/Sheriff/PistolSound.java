
package businessPack.Pieces.Sheriff;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PistolSound {
    //atributos>>
    Media rechargeSound;
    Media shootSound;
    MediaPlayer rechargePlayer;
    MediaPlayer shootPlayer;
    //construtor>>
    public PistolSound(){
        rechargeSound = new Media(getClass().getResource("rechargeSound.mp3").toString());
        shootSound = new Media(getClass().getResource("shootSound.mp3").toString());
        
    }
    //metodos>>
    public void playRechargeSound(){
        rechargePlayer = new MediaPlayer(rechargeSound);
        rechargePlayer.play();
    }
    public void playShootSound(){
        shootPlayer = new MediaPlayer(shootSound);
        shootPlayer.play();
    }
}