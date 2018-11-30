package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import extras.Pistol;
import javafx.scene.image.ImageView;

public class SheriffPeon implements Pistol {
    //atributos>>
    Player player;
    ImageView bullet1;
    int charge = 1;
    //construtor>>
    public SheriffPeon(Player player, ImageView bullet1){
        this.player = player;
        this.bullet1 = bullet1;
    }
    //metodos>>
    @Override
    public void recharge(){
        if(charge < 1) charge++;
        bullet1.setVisible(true);
    }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){
        if(charge != 0){
            for(int jN = vetor.getY(); Table.isInside(0, jN); jN -= player.getSentido()){
                if(table.getBlock(vetor.getX(), jN).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(vetor.getX(), jN).getPiece().hit(charge);
                    bullet1.setVisible(false);
                    charge--;
                    break;
                }
            }
            System.out.println("eh na sola da bota, eh na palma da bota...");
        }
        return false;
    }
}