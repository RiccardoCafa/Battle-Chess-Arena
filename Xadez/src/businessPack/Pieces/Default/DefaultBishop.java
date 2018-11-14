package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Table;
import businessPack.Pieces.Interfaces.ItypeBishop;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultBishop implements ItypeBishop {
    //metodos>>
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
                if(table.getBlock(i, j).getPiece().getTpHero() !=
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
        return vector;
    }
}