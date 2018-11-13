package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Compass;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultHorse implements ItypeHorse {
    //atributos>>
    Player player;
    //construtor>>
    public DefaultHorse(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação da movimentação padrão do cavalo
        ArrayList<Block> freeWay = new ArrayList<>();
        int sinalX = -1, sinalY = -1, valorX = 1, valorY = 2;
        for(int i = 1; i <= 8; i++){
            freeWay.add(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)));
            if(i%4 == 0){ sinalX *= -1; }//***************calculos
            if((i - 1)%2 == 0){ sinalY *= -1; }
            if(i%2 == 0){
                if(valorX == 2){ valorX = 1; valorY = 2; }
                else{ valorX = 2; valorY = 1; }
            }//*******************************************
        }
        try{
            sinalX = -1; sinalY = -1; valorX = 1; valorY = 2;
            for(int i = 1; i <= 8; i++){
                if(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getBlockState(player) == BlockState.Enemy){
                    switch(valorX){
                        case +2://oeste
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.W);
                            break;
                        case -2://leste
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.E);
                            break;
                    }
                    switch(valorY){
                        case +2://norte
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.N);
                            break;
                        case -2://sul
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(Compass.S);
                            break;
                    }
                }
                if(i%4 == 0) sinalX *= -1;//******************calculos
                if((i - 1)%2 == 0) sinalY *= -1;
                if(i%2 == 0){
                    if(valorX == 2){ valorX = 1; valorY = 2; }
                    else{ valorX = 2; valorY = 1; }
                }//*******************************************
            }
        }catch(NullPointerException e){ }
        for(Block block : freeWay){
            if(block.getBlockState(player) == BlockState.Friend){
                freeWay.remove(block);//remove os blocos amigos
            }
        }
        return freeWay;
    }
}