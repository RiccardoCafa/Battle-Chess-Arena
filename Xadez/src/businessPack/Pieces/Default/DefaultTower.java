package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultTower implements ItypeTower {
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        for(int i = vetor.getX()+1;i<table.getM();i++){
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
        for(int i = vetor.getX()-1;i<table.getM();i--){
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
        for(int j = vetor.getY()+1;j<table.getN();j++){
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
        for(int j = vetor.getY()-1;j<table.getN();j--){
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
}