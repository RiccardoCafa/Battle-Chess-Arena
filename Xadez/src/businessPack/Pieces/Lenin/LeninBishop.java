    
package businessPack.Pieces.Lenin;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;


public class LeninBishop implements ItypeBishop{

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        vector.clear();
        // diagonais
        //diagonal para cima e para a esquerda
        for(int i = vetor.getX()-1, j = vetor.getY()-1;i<table.getM();i--,j--){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j));
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j));
                    break;
                }
                break;
            }
        }
        //diagonal para cima e para a direita
        for(int i = vetor.getX()+1, j = vetor.getY()-1;i<table.getM();i++,j--){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j));
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j));
                    break;
                }
            break;
            }
        } 

        //diagonal para baixo e para a esquerda
        for(int i = vetor.getX()-1, j = vetor.getY()+1;i<table.getM();i--,j++){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j));
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j));
                    break;
                }
                break;
            }
        }
        //diagonal para baixo e para a direita
        for(int i = vetor.getX()+1, j = vetor.getY()+1;i<table.getM();i++,j++){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j));
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j));
                    break;
                }
                break;
            }
        }
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
        return vector;
    }
    
}
