package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class SheriffQueen implements ItypeQueen {
    //atributos>>
    Player player;
    int charge = 2;
    //construtor>>
    public SheriffQueen(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {//implementação da rainha especial do Sheriff
        return null;
    }
}
