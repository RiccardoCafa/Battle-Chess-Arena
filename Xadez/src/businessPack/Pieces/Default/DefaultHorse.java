package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
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
            if(Table.isInside(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY))){
                if(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getBlockState(player) != BlockState.Friend){
                    freeWay.add(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)));//adiciona todas as posições válidas
                }
                if(table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getBlockState(player) == BlockState.Enemy){
                    switch(valorX){//apontadores dos blocos inimigos
                        case +2://oeste
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(7);
                            break;
                        case -2://leste
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(3);
                            break;
                    }
                    switch(valorY){
                        case +2://norte
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(1);
                            break;
                        case -2://sul
                            table.getBlock(Vetor.sum(vetor, sinalX*valorX, sinalY*valorY)).getVetor().setTrend(5);
                            break;
                    }
                }
            }
            if(i%4 == 0){ sinalX *= -1; }//***************calculos
            if((i - 1)%2 == 0){ sinalY *= -1; }
            if(i%2 == 0){
                if(valorX == 2){ valorX = 1; valorY = 2; }
                else{ valorX = 2; valorY = 1; }
            }//*******************************************
        }
        for(int i = 2; i <= 8; i += 2){
            if(Table.isInside(vetor.getTrend(i))){
                table.getBlock(vetor.getTrend(i)).getVetor().setTrend(i + 4);//apontadores para a origem
            }
        }
        return freeWay;
    }
}