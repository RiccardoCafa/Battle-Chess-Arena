package businessPack.Pieces.Wizard;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;



public class WizardBishop implements ItypeBishop {

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return table;
    }
}
