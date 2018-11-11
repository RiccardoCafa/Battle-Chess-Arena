package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultQueen implements ItypeQueen {
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> vector;
        vector = new ArrayList<>();
        //linhas retas
        for(int i = vetor.getX()+1;i<table.getM();i++){
            if(table.getBlock(i, vetor.getY())==null){
                vector.add(table.getBlock(i, vetor.getY()).getVetor());
            }else{
                if(table.getBlock(           i, vetor.getY()).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, vetor.getY()).getVetor());
                    break;
                }
                break;
            }
        }
        for(int i = vetor.getX()-1;i<table.getM();i--){
            if(table.getBlock(i, vetor.getY())==null){
                vector.add(table.getBlock(i, vetor.getY()).getVetor());
            }else{
                if(table.getBlock(           i, vetor.getY()).getPiece().getTpHero()!=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, vetor.getY()).getVetor());
                    break;
                }
                break;
            }
        }
        for(int j = vetor.getY()+1;j<table.getN();j++){
            if(table.getBlock(vetor.getX(), j)==null){
                vector.add(table.getBlock(vetor.getX(), j).getVetor());
            }else{
                if(table.getBlock(vetor.getX(),            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(vetor.getX(), j).getVetor());
                    break;
                }
            break;
            }
        }
        for(int j = vetor.getY()-1;j<table.getN();j--){
            if(table.getBlock(vetor.getX(), j)==null){
                vector.add(table.getBlock(vetor.getX(), j).getVetor());
            }else{
                if(table.getBlock(vetor.getX(),            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(vetor.getX(), j).getVetor());
                    break;
                }
                break;
            }
        }
        // diagonais
        //diagonal para cima e para a esquerda
        for(int i = vetor.getX()-1, j = vetor.getY()-1;i<table.getM();i--,j--){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j).getVetor());
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j).getVetor());
                    break;
                }
                break;
            }
        }
        //diagonal para cima e para a direita
        for(int i = vetor.getX()+1, j = vetor.getY()-1;i<table.getM();i++,j--){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j).getVetor());
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j).getVetor());
                    break;
                }
            break;
            }
        } 

        //diagonal para baixo e para a esquerda
        for(int i = vetor.getX()-1, j = vetor.getY()+1;i<table.getM();i--,j++){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j).getVetor());
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j).getVetor());
                    break;
                }
                break;
            }
        }
        //diagonal para baixo e para a direita
        for(int i = vetor.getX()+1, j = vetor.getY()+1;i<table.getM();i++,j++){
            if(table.getBlock(i, j)== null){
                vector.add(table.getBlock(i, j).getVetor());
            }else{
                if(table.getBlock(           i,            j).getPiece().getTpHero() !=
                   table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero()){
                    vector.add(table.getBlock(i, j).getVetor());
                    break;
                }
                break;
            }
        }
        return vector;
    }
}