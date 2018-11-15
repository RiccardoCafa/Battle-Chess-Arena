package businessPack.Pieces.Wizard;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;



public class WizardKing implements ItypeKing {

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return table;
    }
}
