package businessPack;

import java.util.ArrayList;

public class Army {
    //atributos>>
    private ArrayList<Piece> graveyard;
    private ArrayList<Piece> army;
    //private Character char;
    //construtor>>
    public Army(/*Character char*/) {
        graveyard = new ArrayList<>();
        army = new ArrayList<>();
        //this.char = char;
    }
    //metodos>>
    public Piece addPiece(Piece piece) {
        army.add(piece);
        return piece;
    }
    public void ripPiece(Piece piece) {//retira a peça de army e lança em graveyard
        graveyard.add(army.remove(army.indexOf(piece)));
    }
    //getset>>
    public int getArmyNumber(){
        return army.size();
    }
}