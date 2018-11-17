package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class SheriffHorse implements ItypePiece {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffHorse(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        if(charge != 0){
            for(int iE = vetor.getX(); iE < Table.getM(); iE++){
                if(table.getBlock(iE, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(iE, vetor.getY()).getPiece().hit(charge);
                    break;
                }
            }
            for(int iW = vetor.getX(); iW >= 0; iW--){
                if(table.getBlock(iW, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(iW, vetor.getY()).getPiece().hit(charge);
                    break;
                }
            }
            charge--;
        }else charge = 1;
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação do cavalo especial do Sheriff
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
        int a = 3;
        while(a > 0){//movimentos adicionais do cavalo do Sheriff
            if(Table.isInside(vetor.getX(), vetor.getY() - a)){//norte
                freeWay.add(table.getBlock(vetor.getX(), vetor.getY() - a));
                table.getBlock(vetor.getX(), vetor.getY() - a).getVetor().setTrend(5);
            }
            if(Table.isInside(vetor.getX(), vetor.getY() + a)){//sul
                freeWay.add(table.getBlock(vetor.getX(), vetor.getY() + a));
                table.getBlock(vetor.getX(), vetor.getY() + a).getVetor().setTrend(1);
            }
            if(Table.isInside(vetor.getX() + a, vetor.getY())){//leste
                freeWay.add(table.getBlock(vetor.getX() + a, vetor.getY()));
                table.getBlock(vetor.getX() + a, vetor.getY()).getVetor().setTrend(7);
            }
            if(Table.isInside(vetor.getX() - a, vetor.getY())){//oeste
                freeWay.add(table.getBlock(vetor.getX() + a, vetor.getY()));
                table.getBlock(vetor.getX() - a, vetor.getY()).getVetor().setTrend(3);
            }
            a--;
        }
        return freeWay;
    }
}