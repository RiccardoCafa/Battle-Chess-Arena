package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Table;
import businessPack.Player;
import extras.Vetor;
import java.util.ArrayList;
import extras.BlockState;
import extras.Pistol;

public class SheriffTower implements Pistol {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffTower(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public boolean Ireaction(Table table, Vetor vetor, Block enemyBlock){
        if(charge != 0){
            charge--;
            return true;
        }else charge = 1;
        return false;
    }
    public ArrayList<Block> sheriffTowerHitWay(Table table, Vetor vetor){
        ArrayList<Block> hitWay = new ArrayList<>();
        for(int jN = 0; jN < vetor.getY(); jN++){
            if(table.getBlock(vetor.getX(), jN).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(vetor.getX(), jN));
                break;
            }
        }
        for(int jS = Table.getN() - 1; jS > vetor.getY(); jS--){
            if(table.getBlock(vetor.getX(), jS).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(vetor.getX(), jS));
                break;
            }
        }
        for(int iE = Table.getM() - 1; iE > vetor.getX(); iE--){
            if(table.getBlock(iE, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(iE, vetor.getY()));
                break;
            }
        }
        for(int iW = 0; iW < vetor.getX(); iW++){
            if(table.getBlock(iW, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(iW, vetor.getY()));
                break;
            }
        }
        return hitWay;
    }
}