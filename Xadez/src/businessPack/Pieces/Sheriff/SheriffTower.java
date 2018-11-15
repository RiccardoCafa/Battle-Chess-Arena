package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Table;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Player;
import extras.Vetor;
import java.util.ArrayList;

public class SheriffTower implements ItypeTower {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffTower(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação da torre especial do Sheriff
        return null;
    }
}