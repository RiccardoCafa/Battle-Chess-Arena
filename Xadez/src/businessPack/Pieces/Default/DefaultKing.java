package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultKing implements ItypeKing {
    Table tab;
    ArrayList<Block> vector;
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        vector.clear();
        anda(1, 0, vetor);
        anda(-1, 0, vetor);
//           if(table.getBlock(vetor.getX()-1,vetor.getY())==null||table.getBlock(vetor.getX()-1,  
//                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX()-1, vetor.getY()));
//        }
//          if(table.getBlock(vetor.getX(),vetor.getY()-1)==null||table.getBlock(vetor.getX()+1,  
//                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX(), vetor.getY()-1));
//        }
//            if(table.getBlock(vetor.getX(),vetor.getY()+1)==null||table.getBlock(vetor.getX()-1,  
//                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX(), vetor.getY()+1));
//        }   
//            if(table.getBlock(vetor.getX()+1,vetor.getY()+1)==null||table.getBlock(vetor.getX()+1,  
//                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX()+1, vetor.getY()+1));
//        }
//         if(table.getBlock(vetor.getX()-1,vetor.getY()-1)==null||table.getBlock(vetor.getX()-1,  
//                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX()-1, vetor.getY()-1));
//        }
//          if(table.getBlock(vetor.getX()+1,vetor.getY()-1)==null||table.getBlock(vetor.getX()+1,  
//                vetor.getY()-1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX()+1, vetor.getY()-1));
//        }
//           if(table.getBlock(vetor.getX()-1,vetor.getY()+1)==null||table.getBlock(vetor.getX()-1,  
//                vetor.getY()+1).getPiece().getTpHero() != table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
//            vector.add(table.getBlock(vetor.getX()-1, vetor.getY()+1));
//        }
        return vector;
    }
    
    public void anda(int xDir, int yDir, Vetor vetor) {
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        if(tab.getBlock(newVetor)==null || 
                tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()){
         vector.add(tab.getBlock(newVetor));
         System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
        }
    }

}