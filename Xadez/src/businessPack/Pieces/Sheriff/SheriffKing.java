package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import javafx.scene.image.ImageView;

public class SheriffKing implements Pistol{
    //atributos>>
    Player player;
    ImageView bullet1;
    ImageView bullet2;
    int charge = 2;
    boolean discharging;//descarregando o pente
    //construtor>>
    public SheriffKing(Player player, ImageView bullet1, ImageView bullet2){
        this.player = player;
        this.bullet1 = bullet1;
        this.bullet2 = bullet2;
        discharging = true;
    }
    //metodos>>
    @Override
    public void recharge(){//recarga
        if(charge < 2){
            charge++;
            MP3.playRechargeSound();
        }
        if(charge == 1) bullet1.setVisible(true);
        if(charge == 2) bullet2.setVisible(true);
    }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){//reação do SheriffKing
        if(charge == 0) discharging = false;//zerou o pente, carregue-o
        if(charge == 2) discharging = true;//pente completo, descarregue-o
        if(discharging){//se está apto a descarregar o pente
            enemyBlock.hitPiece(charge);//atinge quem o irá atacar
            System.out.println("sou matador de onça");
            if(charge == 1) bullet1.setVisible(false);//última bala do pente usada 
            if(charge == 2) bullet2.setVisible(false);//bala usada
            charge--;
            MP3.playShootSound();
        }else recharge();//pente vazio, comece a encher
        return false;
    }
}