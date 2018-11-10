package businessPack;

import javafx.scene.image.Image;

public abstract class Hero {
    //atributos>>
    private Image image;
    //construtor>>
    public Hero(Image image) {
        this.image = image;
    }
    //metodos>>
    public abstract void createArmy(Army army, int sentido);
    //getset>>
    public Image getIMage(){
        return image;
    }
}