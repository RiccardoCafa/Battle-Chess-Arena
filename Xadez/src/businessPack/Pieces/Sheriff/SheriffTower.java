package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Table;
import businessPack.Player;
import extras.Vetor;
import java.util.ArrayList;
import extras.BlockState;
import javafx.scene.image.ImageView;

public class SheriffTower implements Pistol{
    //atributos>>
    Player player;
    ImageView bullet1;
    int charge;
    boolean discharging;//descarregando o pente
    //construtor>>
    public SheriffTower(Player player, ImageView bullet1){
        this.player = player;
        this.bullet1 = bullet1;
        charge = 1;
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
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){//reação da SheriffTower
        if(charge == 0) discharging = false;//zerou o pente, carregue-o
        if(charge == 1) discharging = true;//pente completo, descarregue-o
        if(discharging) return true;//se ainda tem bala no cartucho, ativa a reação em GameCtrl
        else recharge();//pente vazio, comece a encher
        return false;
    }
    public ArrayList<Block> sheriffTowerHitWay(Table table, Vetor vetor){//criação das opções de tiro
        ArrayList<Block> hitWay = new ArrayList<>();
        for(int jN = 0; jN < vetor.getY(); jN++){//procura a peça inimiga mais ao Norte
            if(table.getBlock(vetor.getX(), jN).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(vetor.getX(), jN));
                break;
            }
        }
        for(int jS = Table.getN() - 1; jS > vetor.getY(); jS--){//procura a peça inimiga mais ao Sul
            if(table.getBlock(vetor.getX(), jS).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(vetor.getX(), jS));
                break;
            }
        }
        for(int iE = Table.getM() - 1; iE > vetor.getX(); iE--){//procura a peça inimiga mais ao Leste
            if(table.getBlock(iE, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(iE, vetor.getY()));
                break;
            }
        }
        for(int iW = 0; iW < vetor.getX(); iW++){//procura a peça inimiga mais ao Oeste
            if(table.getBlock(iW, vetor.getY()).getBlockState(player) == BlockState.Enemy){
                hitWay.add(table.getBlock(iW, vetor.getY()));
                break;
            }
        }
        if(hitWay.size() == 1){//se existe apenas uma opção de tiro
            realShoot(table, hitWay.get(0));//atinga o único inimigo disponível
            hitWay.clear();//esvazia a lista
        }
        return hitWay;//ou está vazia ou com mais de dois itens
    }
    public void realShoot(Table table, Block enemyBlock){//causa o efetivo dano
        enemyBlock.hitPiece(charge);
        bullet1.setVisible(false);//bala usada
        charge--;
        pistolSounds.playShootSound();
    }
    //getset>>
    public int getCharge(){//retorna o dano que se pode causar
        return charge;
    }
}