package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import extras.Pistol;

public class SheriffKing implements Pistol {
    //atributos>>
    Player player;
    int charge = 2;
    //construtor>>
    public SheriffKing(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public boolean Ireaction(Table table, Vetor vetor, Block enemyBlock){
        if(charge != 0){
            enemyBlock.hitPiece(charge);
            System.out.println("sou matador de onça");
            charge--;
        }else{
            if(charge < 2) charge++;
        }
        return false;
    }
}