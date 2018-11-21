package businessPack;

import extras.Who;
import javafx.scene.image.Image;

public abstract class Hero {
    //atributos>>
    protected Player player;
    protected Image image;
    protected final float widthImg = 520;
    protected final float heightImg = 420;
    protected final String path = "InterfaceView/Personagens/";
    protected TypeHero tpHero;
    //construtor>>
    public Hero() {
    }
    //metodos>>
    public abstract void createArmy(Army army, int sentido, Who who);
    //getset>>
    public Image getImage(){
        return image;
    }
}