
package businessPack;

import java.util.ArrayList;


public class Exercito {
    
    private ArrayList<Piece> Graveyard;
    private ArrayList<Piece> army;


    public Exercito() {
        Graveyard = new ArrayList<>();
        army = new ArrayList<>();
    }
    
    public Piece addPieceToArmy(Piece e) {
        army.add(e);
        return e;
    }
    
    //method for attack a piece in the sigth of other
    public boolean Attack(Piece atcker, Piece victm, Player enemy){
         victm.healthPoints = victm.healthPoints - atcker.getPieceDamage();
         if(victm.getHealthPoints() == 0){
             enemy.exercito.army.remove(victm);
             enemy.exercito.Graveyard.add(victm);
         }
         
         return true;
         
     }
     // number of the army
    public int getArmyNumber(){
        return army.size();
    } 

   
    
    
}


 
   

