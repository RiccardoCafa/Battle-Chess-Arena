package businessPack.Pieces.Wizard;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;



public class WizardKing implements ItypePiece {

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
}
