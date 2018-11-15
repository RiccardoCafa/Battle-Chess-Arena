package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class SheriffPeon implements ItypePeon {
    //atributos>>
    Player player;
    int charge = 1;
    //construtor>>
    public SheriffPeon(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação do peão especial do Sheriff
        return null;
    }
}