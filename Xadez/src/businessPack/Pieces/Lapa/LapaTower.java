package businessPack.Pieces.Lapa;

import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

/**
 *
 * @author ricca
 */
public class LapaTower implements ItypeTower {

    int casasOffSet;
    int count;
    
    @Override
    public ArrayList<Vetor> IcheckMove(Table table, Vetor vetor) {
        int ycount = 1;
        int i = vetor.getX();
        ArrayList<Vetor> newPosList = new ArrayList<Vetor>();
        for(int j = vetor.getY(); j < table.getN(); j++) {    
            if(!(j>= table.getN())){
                if(table.getBloco(i, j+1) == null) {
                    
                }    
            
            }
        }
        for(i = vetor.getX(); i < table.getM(); i++) {
            
        }
        
    }
    
}
