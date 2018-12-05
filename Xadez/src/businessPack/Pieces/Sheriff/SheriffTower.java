package businessPack.Pieces.Sheriff;

import InterfaceView.GameManager;
import businessPack.Block;
import businessPack.Table;
import businessPack.Player;
import businessPack.TypeClicks.ClickOnBlock;
import businessPack.TypeClicks.TypeClick;
import extras.Vetor;
import java.util.ArrayList;
import extras.BlockState;
import javafx.scene.image.ImageView;

public class SheriffTower implements Pistol, ClickOnBlock{
    //atributos>>
    Player player;
    ImageView bullet1;
    int charge;
    boolean discharging;//descarregando o pente
    boolean isShooting;
    Block priorBlockClicked;
    GameManager game;
    //construtor>>
    public SheriffTower(Player player, ImageView bullet1){
        this.player = player;
        this.bullet1 = bullet1;
        charge = 1;
        discharging = true;
        isShooting = false;
    }
    //metodos>>
    @Override
    public void recharge(){//recarga
        if(charge < 1){
            charge++;
            MP3.playRechargeSound();
        }
        isShooting = false;
        bullet1.setVisible(true);
    }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){//reação da SheriffTower
        if(charge == 0) discharging = false;//zerou o pente, carregue-o
        if(charge == 1) discharging = true;//pente completo, descarregue-o
        if(discharging){//se ainda tem bala no cartucho, ativa a reação em GameCtrl
            isShooting = false;
            return true;
        }
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
        return hitWay;
    }
    @Override
    public TypeClick click(Block blockClicked){
        ArrayList<Block> hitWay = sheriffTowerHitWay(game.getTable(), game.getSheriffBlock().getVetor());
        if(!isShooting){//se é o momento de mostrar as opções de tiro
            game.clearHighlight();
            isShooting = true;
            game.setSheriffBlock(blockClicked);
            if(hitWay.isEmpty()){//se não existe opção para atirar
                isShooting = false;
                game.setSheriffBlock(null);
                game.setClickSequence(true);
                return TypeClick.hit;
            }else if(hitWay.size() == 1){//se só existe uma opção
                hitWay.get(0).hitPiece(charge);
                isShooting = false;
                bullet1.setVisible(false);//bala usada
                charge--;
                MP3.playShootSound();
                if(priorBlockClicked != null){//se a peça atingida estiver viva
                    game.clearHighlight();
                    game.setClickSequence(true);
                    return TypeClick.hit;
                }else{//se a peça atingida morreu
                    game.removeImage(priorBlockClicked);
                    game.setSheriffBlock(null);
                    game.setClickSequence(true);
                    return TypeClick.last;
                }
            }else{//se existe mais de uma opção de ataque
                game.showPossibleEnemys(hitWay);
                isShooting = true;
                game.setClickSequence(false);
                return TypeClick.sheriffTower;
            }
        }else{//se é o momento de atirar
            if(!hitWay.contains(blockClicked)){//se clicou num bloco inválido
                game.setClickSequence(false);
                return TypeClick.sheriffTower;
            }
            blockClicked.hitPiece(charge);
            isShooting = false;
            bullet1.setVisible(false);//bala usada
            charge--;
            MP3.playShootSound();
            if(priorBlockClicked != null){//se a peça atingida estiver viva
                game.clearHighlight();
                game.setClickSequence(true);
                return TypeClick.hit;
            }else{//se a peça atingida morreu
                game.removeImage(priorBlockClicked);
                game.setSheriffBlock(null);
                game.setClickSequence(true);
                return TypeClick.last;
            }
        }
    }
    //getset>>
    public void setTurnAtributes(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
}