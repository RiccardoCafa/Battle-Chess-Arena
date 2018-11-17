package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Player;
import extras.Who;
import javafx.scene.image.Image;
public class Lapa extends Hero {
    
    public Lapa() {
        image = new Image(path + "lapa-01.png", widthImg, heightImg, false, false);
    }

    @Override
    public void createArmy(Army army, int sentido, Who jogador) {
        
    }

    
    //LapaGod
}
