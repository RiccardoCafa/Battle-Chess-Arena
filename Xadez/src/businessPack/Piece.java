
package businessPack;

import javafx.scene.image.Image;


public abstract class Piece {
    
    public String name;
    public Image myImage;
    public int healthPoints;
    public boolean alive;
    
    public Piece(String n, Image im, int heal, boolean al){
        name = n;
        myImage = im;
        healthPoints = heal;
        alive = al;
    }
    public void Move(){
        
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void getHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int setHealthPoints(){
        return healthPoints;
    }
    public void setLife(boolean alive){
        this.alive = alive;
    }
    public boolean getLife(){
        return alive;
    }
    
   // getter for the variable Image
    public Image getMyImage(Image myImage){
        return myImage;
    }
    
    
    
    
    
    
    
    
}
