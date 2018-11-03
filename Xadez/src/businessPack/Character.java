package businessPack;

import businessPack.Pecas.King;
import javafx.scene.image.Image;

public abstract class Character {
    public Image myFace;
    public King myHero;
    // public Exercito army;
    
    //public abstract Joke();
    public Character(Image myFace, King myHero) {
        this.myFace = myFace;
        this.myHero = myHero;
    }
    
    public Image getMyFace(){
        return myFace;
    }
    
    public King getKing(){
        return myHero;
    }
}