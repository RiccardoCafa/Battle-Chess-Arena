
package businessPack;

import java.util.ArrayList;


public class Exercito {
    ArrayList<Piece> deadPieces;
    ArrayList<Piece> pieces;
    
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
        if(pieces.size()==0){
            return true;
        }else return false;
    }
    
    
    
    
    
}

 
   

