
package businessPack.Pieces.EnemyLenin;

import businessPack.Block;
import businessPack.Table;
import businessPack.Pieces.Interfaces.ItypePiece;
import extras.Vetor;
import java.util.ArrayList;

public class EnemyHorseLenin implements ItypePiece {

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        vector.clear();
        for(int i = vetor.getX()+1;i<vetor.getX()+2;i++){
            if(table.getBlock(i, vetor.getY())==null){
                vector.add(table.getBlock(i, vetor.getY()));
            }else{
                if(table.getBlock(           i, vetor.getY()).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, vetor.getY()));
                    break;
                }
                break;
            }
        }
        for(int i = vetor.getX()-1;i<vetor.getX()-2;i--){
            if(table.getBlock(i, vetor.getY())==null){
                vector.add(table.getBlock(i, vetor.getY()));
            }else{
                if(table.getBlock(           i, vetor.getY()).getPiece().getTpHero()!=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, vetor.getY()));
                    break;
                }
                break;
            }
        }
        for(int j = vetor.getY()+1;j<vetor.getY()+2;j++){
            if(table.getBlock(vetor.getX(), j)==null){
                vector.add(table.getBlock(vetor.getX(), j));
            }else{
                if(table.getBlock(vetor.getX(),            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(vetor.getX(), j));
                    break;
                }
            break;
            }
        }
        for(int j = vetor.getY()-1;j<vetor.getY()-2;j--){
            if(table.getBlock(vetor.getX(), j)==null){
                vector.add(table.getBlock(vetor.getX(), j));
            }else{
                if(table.getBlock(vetor.getX(),            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(vetor.getX(), j));
                    break;
                }
                break;
            }
        }
        return vector;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
}
