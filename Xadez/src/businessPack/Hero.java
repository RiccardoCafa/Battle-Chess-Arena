package businessPack;

import businessPack.Heros.HeroManager;
import extras.Who;
import javafx.scene.image.Image;

public abstract class Hero implements HeroManager {
    //atributos>>
    protected Player player;
    protected Image image;
    protected Image heroIcon;
    protected final float widthImg = 520;
    protected final float heightImg = 420;
    protected final float widthIcon = 375;
    protected final float heightIcon = 330;
    protected final String path = "InterfaceView/Personagens/";
    protected TypeHero tpHero;
    protected String heroName;
    
    //construtor>>
    public Hero() {
    }
    //metodos>>
    public abstract void createArmy(Army army, int sentido, Who who);
    
    public Image getImageIcon(int width, int height) {
        heroIcon = new Image("InterfaceView/Personagens/icone" + heroName + ".png", width, height, false, false);
        return heroIcon;
    }
    //getset>>
    public Image getImage(){
        return image;
    }
    public TypeHero getHeroType() {
        return tpHero;
    }
    public String getHeroName() {
        return heroName;
    }
}