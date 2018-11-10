package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Table;
import extras.Compass;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultHorse implements ItypeHorse {
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação da movimentação padrão do cavalo
        ArrayList<Block> freeWay = new ArrayList<>();
        int sinalX = -1, sinalY = -1, valorX = 1, valorY = 2;
        for(int i = 1; i <= 8; i++){
            freeWay.add(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)));
            if(i%4 == 0){ sinalX *= -1; }
            if((i - 1)%2 == 0){ sinalY *= -1; }
            if(i%2 == 0){
                if(valorX == 2){ valorX = 1; valorY = 2; }
                else{ valorX = 2; valorY = 1; }
            }
        }
        try{
            sinalX = -1;
            sinalY = -1;
            valorX = 1;
            valorY = 2;
            for(int i = 1; i <= 8; i++){
                switch(valorX){
                    case 2:
                        table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.W);
                        break;
                    case -2:
                        table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.E);
                        break;
                }
                switch(valorY){
                    case 2:
                        table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.N);
                        break;
                    case -2:
                        table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.S);
                        break;
                }
                if(i%4 == 0) sinalX *= -1;
                if((i - 1)%2 == 0) sinalY *= -1;
                if(i%2 == 0){
                    if(valorX == 2){ valorX = 1; valorY = 2; }
                    else{ valorX = 2; valorY = 1; }
                }
            }
        }catch(NullPointerException e){}
        for(Block block : freeWay){
            if(block.getPiece().getTpHero() == table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                freeWay.remove(block);
            }
        }
        return freeWay;
    }
}