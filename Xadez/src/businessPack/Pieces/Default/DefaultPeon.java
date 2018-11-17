package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultPeon implements ItypePiece {
    //metodos>>
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        //implementação da movimentação padrão do peão
        return null;
    }
}