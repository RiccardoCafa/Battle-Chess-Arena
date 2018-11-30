package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Table;
import businessPack.Player;
import extras.Vetor;
import java.util.ArrayList;
import extras.BlockState;
import extras.Pistol;
import javafx.scene.image.ImageView;

public class SheriffTower implements Pistol {
    //atributos>>
    Player player;
    ImageView bullet1;
    int charge;
    //construtor>>
    public SheriffTower(Player player, ImageView bullet1){
        this.player = player;
        this.bullet1 = bullet1;
        charge = 1;
    }
    //metodos>>
    @Override
    public void recharge(){
        if(charge < 1) charge++;
        bullet1.setVisible(true);
    }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock, boolean protectQueen){
        if(charge != 0) return true;
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
    public void realShoot(Table table, Block enemyBlock){
        if(charge != 0){
            enemyBlock.hitPiece(charge);
            bullet1.setVisible(false);
            charge--;
        }else recharge();
    }
    //getset>>
    public int getCharge(){
        return charge;
    }
}