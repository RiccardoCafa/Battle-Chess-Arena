package businessPack;

import extras.PlayerPiece;
import javafx.scene.image.Image;

public abstract class Hero {
    //atributos>>
    private Image image;
    //construtor>>
    public Hero(Image image) {
        this.image = image;
    }
    //metodos>>
    public abstract void createArmy(Army army, int sentido,PlayerPiece jogador);
    //getset>>
    public Image getIMage(){
        return image;
    }
}