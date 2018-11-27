package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Table;
import businessPack.Player;
import extras.Vetor;
import java.util.ArrayList;
import extras.BlockState;
import extras.Pistol;
import businessPack.Pieces.Interfaces.Movement;

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
            System.out.println("");
            charge--;
            return true;
        }else charge = 1;
        return false;
    }
}