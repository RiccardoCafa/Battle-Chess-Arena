package businessPack;

import java.util.ArrayList;

public class Army {
    //atributos>>
    private ArrayList<Piece> graveyard;
    private ArrayList<Piece> army;
    //construtor>>
    public Army() {
        graveyard = new ArrayList<>();
        army = new ArrayList<>();
    }
    //metodos>>
    public Piece addPiece(Piece piece) {
        army.add(piece);
        return piece;
    }
    public void ripPiece(Piece piece) {//retira a peça de army e lança em graveyard
        graveyard.add(army.remove(army.indexOf(piece)));
    }
    public Piece findPiece(int x, int y){//retorna a peça da posição requerida
        for(Piece piece : army){
            if(piece.getVetor().getX() == x && piece.getVetor().getY() == y){
                return piece;
            }
        }
        return null;
    }
    //getset>>
    public int getArmyNumber(){
        return army.size();
    }
    public ArrayList<Piece> getArmyList(){
        return army;
    }
}