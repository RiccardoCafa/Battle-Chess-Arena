
package businessPack.Pieces.EnemyLenin;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
public class EnemyPeonLenin implements ItypePeon{

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        vector.clear();
        vector.add(null);
        return vector;
    }
    
}
