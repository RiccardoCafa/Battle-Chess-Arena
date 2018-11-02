
package businessPack;

import java.util.ArrayList;


public class Exercito {
   public ArrayList<Piece> deadPieces; //list of dead pieces
   public ArrayList<Piece> pieces; // list of alive pieces
   public int killCount = 0; 
   //oo
    public Exercito() {
        this.deadPieces = new ArrayList<>();
        this.pieces =  new ArrayList<>();
    }
    
    
    
    //remove the dead pieces from the board
    public void entomb(Piece p){
        if(p.alive == false){
            pieces.remove(p);
            deadPieces.add(p);
        }
    }
    
    // function that ends the game, if the list of alive pieces is empty
    public boolean endGame(){
        if(pieces.isEmpty()){
            return true;
        }else return false;
    }
    
    //method for attack a piece in the sigth of other
    public boolean Attack(Piece atcker, Piece victm){
         victm.healthPoints = victm.healthPoints - atcker.getPieceDamage();
         if(victm.healthPoints == 0){
             killCount++;
         }
         return true;
         
     }
     // number of the army
    public int getArmyNumber(){
        return pieces.size();
    } 
     
    
    
    
    
    
}

 
   

