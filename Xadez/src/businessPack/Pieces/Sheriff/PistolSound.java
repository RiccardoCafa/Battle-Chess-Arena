package businessPack.Pieces.Sheriff;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PistolSound {
    //atributos>>
//    private String[] paths = {
//        new File("src/businessPack/Pieces/Sheriff/rechargeSound.mp3").getAbsolutePath(),
//        new File("src/businessPack/Pieces/Sheriff/shootSound.mp3").getAbsolutePath()
//    };
    Media[] sounds = {
        new Media(getClass().getResource("rechargeSound.mp3").toString()),
        new Media(getClass().getResource("shootSound.mp3").toString())};
    MediaPlayer sound1 = new MediaPlayer(sounds[0]);
    MediaPlayer sound2 = new MediaPlayer(sounds[1]);
    //metodos>>
    public void playRechargeSound(){ sound1.play(); }
    public void playShootSound(){ sound2.play(); }
}