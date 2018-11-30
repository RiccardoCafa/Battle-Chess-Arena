package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import extras.Pistol;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SheriffKing implements Pistol {
    //atributos>>
    Player player;
    ImageView bullet1;
    ImageView bullet2;
    int charge = 2;
    //construtor>>
    public SheriffKing(Player player, ImageView bullet1, ImageView bullet2){
        this.player = player;
        this.bullet1 = bullet1;
        this.bullet2 = bullet2;
    }
    //metodos>>
    @Override
    public void recharge(){
        if(charge < 2) charge++;
        if(charge == 1) bullet1.setVisible(true);
        if(charge == 2) bullet2.setVisible(true);
    }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock, boolean protectQueen){
        if(charge != 0){
            enemyBlock.hitPiece(charge);
            System.out.println("sou matador de onça");
            if(charge == 1) bullet1.setVisible(false);
            if(charge == 2) bullet2.setVisible(false);
            charge--;
        }else if(!protectQueen) recharge();
        return false;
    }
}