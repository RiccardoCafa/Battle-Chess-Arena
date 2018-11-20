package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class SheriffPeon implements ItypePiece {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffPeon(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        if(charge != 0){
            for(int jN = vetor.getY(); Table.isInside(new Vetor(0, jN)); jN += player.getSentido()){
                if(table.getBlock(jN, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(jN, vetor.getY()).getPiece().hit(charge);
                    break;
                }
            }
            charge--;
        }else charge = 1;
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação do peão especial do Sheriff
        return null;
    }
}