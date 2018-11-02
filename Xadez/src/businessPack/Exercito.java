
package businessPack;

import java.util.ArrayList;


public class Exercito {
    private ArrayList<Piece> listPiecesDead;
    private ArrayList<Piece> army;

    public Exercito() {
        this.listPiecesDead = new ArrayList<>();
        this.army = new ArrayList<>();
    }
    
    public void addPieceToArmy(Piece e) {
        army.add(e);
    }
    
}

 
   

