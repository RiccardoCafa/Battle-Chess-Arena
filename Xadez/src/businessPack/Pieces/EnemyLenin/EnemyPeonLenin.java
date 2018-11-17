
package businessPack.Pieces.EnemyLenin;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
public class EnemyPeonLenin implements ItypePiece{

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        vector.clear();
        vector.add(null);
        return vector;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
}
