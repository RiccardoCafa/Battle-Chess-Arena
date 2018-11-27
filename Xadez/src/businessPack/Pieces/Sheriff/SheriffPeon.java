package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import extras.Pistol;

public class SheriffPeon implements Pistol {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffPeon(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public boolean Ireaction(Table table, Vetor vetor, Block enemyBlock){
        if(charge != 0){
            for(int jN = vetor.getY(); Table.isInside(0, jN); jN -= player.getSentido()){
                if(table.getBlock(vetor.getX(), jN).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(vetor.getX(), jN).getPiece().hit(charge);
                    break;
                }
            }
            System.out.println("eh na sola da bota, eh na palma da bota...");
            charge--;
        }else charge = 1;
        return false;
    }
}