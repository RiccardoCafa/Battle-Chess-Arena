package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class SheriffKing implements ItypeKing {
    //atributos>>
    Player player;
    int charge = 2;
    //construtor>>
    public SheriffKing(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação do rei especial do Sheriff
        return null;
    }
}