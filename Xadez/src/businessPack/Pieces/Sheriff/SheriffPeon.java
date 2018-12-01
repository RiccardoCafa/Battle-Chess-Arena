package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import javafx.scene.image.ImageView;

public class SheriffPeon implements Pistol{
    //atributos>>
    Player player;
    ImageView bullet1;
    int charge = 1;
    boolean discharging;//descarregando o pente
    //construtor>>
    public SheriffPeon(Player player, ImageView bullet1){
        this.player = player;
        this.bullet1 = bullet1;
        discharging = true;
    }
    //metodos>>
    @Override
    public void recharge(){//recarga
        if(charge < 1){
            charge++;
            pistolSounds.playRechargeSound();
        }
        bullet1.setVisible(true);
    }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){//reação do SheriffPeon
        if(charge == 0) discharging = false;//zerou o pente, carregue-o
        if(charge == 1) discharging = true;//pente completo, descarregue-o
        if(discharging){//se está apto a descarregar o pente
            for(int j = vetor.getY(); Table.isInside(0, j); j -= player.getSentido()){//procura a primeira peça inimiga à sua frente
                if(table.getBlock(vetor.getX(), j).getBlockState(player) == BlockState.Enemy){
                    table.getBlock(vetor.getX(), j).hitPiece(charge);
                    bullet1.setVisible(false);//bala usada
                    charge--;
                    pistolSounds.playShootSound();
                    break;
                }
            }
            System.out.println("eh na sola da bota, eh na palma da bota...");
        }else recharge();//pente vazio, comece a encher
        return false;
    }
}