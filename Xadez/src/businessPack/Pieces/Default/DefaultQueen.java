package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultQueen implements ItypeQueen {
    //metodos>>
    @Override
    public ArrayList<Vetor> IcheckMove(Table table,Vetor vetor) {
        ArrayList<Vetor> vector;
        vector = new ArrayList<>();
        for(int i = vetor.getX()+1;i<table.getM();i++){
            if(table.getBlock(i, vetor.getY())==null){
                vector.add(table.getBlock(i, vetor.getY()).getVetor());
            }else{
                break;
            }  
                    }
          for(int i = vetor.getX()-1;i<table.getM();i--){
            if(table.getBlock(i, vetor.getY())==null){
                vector.add(table.getBlock(i, vetor.getY()).getVetor());
            }else{
                break;
            }  
                    }
         for(int j = vetor.getY()+1;j<table.getN();j++){
                if(table.getBlock(vetor.getX(), j)==null){
                    vector.add(table.getBlock(vetor.getX(), j).getVetor());
            }else{
                    
                    break;
                    }
         }
         for(int j = vetor.getY()-1;j<table.getN();j--){
                if(table.getBlock(vetor.getX(), j)==null){
                    vector.add(table.getBlock(vetor.getX(), j).getVetor());
            }else{
                    
                    break;
                    }
         }
         
        //implementação da movimentação padrão do rainha
        return null;
    }
}