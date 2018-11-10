package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultKing implements ItypeKing {
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
           if(table.getBlock(vetor.getX()+1,vetor.getY())==null||table.getBlock(vetor.getX()+1,  
                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX()+1, vetor.getY()));
        }
           if(table.getBlock(vetor.getX()-1,vetor.getY())==null||table.getBlock(vetor.getX()-1,  
                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX()-1, vetor.getY()));
        }
          if(table.getBlock(vetor.getX(),vetor.getY()-1)==null||table.getBlock(vetor.getX()+1,  
                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX(), vetor.getY()-1));
        }
            if(table.getBlock(vetor.getX(),vetor.getY()+1)==null||table.getBlock(vetor.getX()-1,  
                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX(), vetor.getY()+1));
        }   
            if(table.getBlock(vetor.getX()+1,vetor.getY()+1)==null||table.getBlock(vetor.getX()+1,  
                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX()+1, vetor.getY()+1));
        }
         if(table.getBlock(vetor.getX()-1,vetor.getY()-1)==null||table.getBlock(vetor.getX()-1,  
                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX()-1, vetor.getY()-1));
        }
          if(table.getBlock(vetor.getX()+1,vetor.getY()-1)==null||table.getBlock(vetor.getX()+1,  
                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX()+1, vetor.getY()-1));
        }
           if(table.getBlock(vetor.getX()-1,vetor.getY()+1)==null||table.getBlock(vetor.getX()-1,  
                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
            vector.add(table.getBlock(vetor.getX()-1, vetor.getY()+1));
        }
        return vector;
    }
}