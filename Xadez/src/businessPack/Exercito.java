
package businessPack;

import java.util.ArrayList;


public class Exercito {
    private ArrayList<Piece> listPiecesDead;
    private ArrayList<Piece> army;

    public Exercito() {
        listPiecesDead = new ArrayList<>();
        army = new ArrayList<>();
    }
    
    public Piece addPieceToArmy(Piece e) {
        army.add(e);
        return e;
    }
    
}

 
   

