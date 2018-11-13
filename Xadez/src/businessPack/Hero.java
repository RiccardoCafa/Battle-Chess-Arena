package businessPack;

import javafx.scene.image.Image;

public abstract class Hero {
    //atributos>>
    protected Image image;
    protected TypeHero tpHero;
    //construtor>>
    public Hero(Image image) {
        this.image = image;
        
    }
    //metodos>>
    public abstract void createArmy(Army army, int sentido, Player player);
    //getset>>
    public Image getImage(){
        return image;
    }
}