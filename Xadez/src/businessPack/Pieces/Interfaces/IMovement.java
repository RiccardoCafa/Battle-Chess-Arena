package businessPack.Pieces.Interfaces;

import businessPack.Block;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public interface IMovement {
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor);
}