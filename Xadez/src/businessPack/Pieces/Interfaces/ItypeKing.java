package businessPack.Pieces.Interfaces;

import businessPack.Block;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public interface ItypeKing {
    public Table reaction(Table table, Vetor vetor);
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor);
}