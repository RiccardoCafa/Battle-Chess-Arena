
package businessPack;

import java.util.ArrayList;


public class Exercito {
<<<<<<< HEAD
   public ArrayList<Piece> deadPieces; //list of dead pieces
   public ArrayList<Piece> pieces; // list of alive pieces
   public int killCount = 0; 
   //oo
=======
    private ArrayList<Piece> listPiecesDead;
    private ArrayList<Piece> army;

>>>>>>> master
    public Exercito() {
        listPiecesDead = new ArrayList<>();
        army = new ArrayList<>();
    }
    
    public Piece addPieceToArmy(Piece e) {
        army.add(e);
        return e;
    }
    
<<<<<<< HEAD
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
     
    
    
    
    
    
=======
>>>>>>> master
}

 
   

