
package businessPack;

import javafx.scene.image.Image;


public abstract class Piece {
    
    public String name;
    public Image myImage;
    public int healthPoints;
    public boolean alive;
    public int pieceDamage;
    
    public Piece(String n, Image im, int heal, int pd){
        name = n;
        myImage = im;
        healthPoints = heal;
        pieceDamage = pd;
    }
    
    public Piece(String n, int heal, int pd){
        name = n;
        healthPoints = heal;
        pieceDamage = pd;
    }
    
    public Piece(String n, Image im, int heal, boolean al, int pd){
        name = n;
        myImage = im;
        healthPoints = heal;
        alive = al;
        pieceDamage = pd;
    }
    
    public abstract void Move();
    
    public abstract void CheckMovePossibility(Tabuleiro tab);
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints(){
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
    public int getPieceDamage(){
        return pieceDamage;
    }
    
    
    
    
    
    
    
}
