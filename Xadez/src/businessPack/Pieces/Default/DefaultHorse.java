package businessPack.Pieces.Default;

import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultHorse implements ItypeHorse {
    //metodos>>
    @Override
    public ArrayList<Vetor> IcheckMove(Table table, Vetor vetor) {//implementação da movimentação padrão do cavalo
        ArrayList<Vetor> freeWay = new ArrayList<>();
        freeWay.add(new Vetor(vetor.getX() - 1, vetor.getY() - 2));
        freeWay.add(new Vetor(vetor.getX() - 1, vetor.getY() + 2));
        freeWay.add(new Vetor(vetor.getX() - 2, vetor.getY() + 1));
        freeWay.add(new Vetor(vetor.getX() - 2, vetor.getY() - 1));
        freeWay.add(new Vetor(vetor.getX() + 1, vetor.getY() - 2));
        freeWay.add(new Vetor(vetor.getX() + 1, vetor.getY() + 2));
        freeWay.add(new Vetor(vetor.getX() + 2, vetor.getY() + 1));
        freeWay.add(new Vetor(vetor.getX() + 2, vetor.getY() - 1));
        for(Vetor position : freeWay){
            if(position.getX() < 0 || position.getX() > table.getM() ||
               position.getY() < 0 || position.getY() > table.getN()){
                freeWay.remove(position);
            }
        }
        for(Vetor position : freeWay){
            if(table.getBlock(position.getX(), position.getY()).getPiece().getTpHero() ==
               table.getBlock(   vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                freeWay.remove(position);
            }
        }
        return freeWay;
    }
}