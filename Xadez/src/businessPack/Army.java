
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
    public void addPiece(Piece piece) {
        army.add(piece);
    }
    public void ripPiece(Piece piece) {//retira a peça de army e lança em graveyard
        graveyard.add(army.remove(army.indexOf(piece)));
    }/*
    public boolean Attack(Piece atcker, Piece victm, Player enemy){//method for attack a piece in the sigth of other
        victm.healthPoints = victm.healthPoints - atcker.getPieceDamage();
        if(victm.getHealthPoints() == 0){
            enemy.exercito.army.remove(victm);
            enemy.exercito.Graveyard.add(victm);
        }
        return true;
    }*/
    //getset>>
    public int getArmyNumber(){
        return army.size();
    }
}