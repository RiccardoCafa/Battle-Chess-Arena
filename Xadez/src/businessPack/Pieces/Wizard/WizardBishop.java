package businessPack.Pieces.Wizard;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;



public class WizardBishop implements ItypePiece {
    
    Table tab;
    ArrayList<Block> vect;
    Player playing;
    
    public WizardBishop(Player p){
        this.playing = p;
    }
    
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor){
        vect = new ArrayList<>();
        tab = table;
        return vect;
        
        
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }   
    
    public Vetor behindBlocks(int xGo, int yGo, Vetor vet, int num){
        int i = vet.getX() + xGo;
        int j = vet.getY() + yGo;
        Vetor auxVetor = new Vetor(i, j);
        //condições de parada
        if(j < 0 || j > 7 || i < 0 || i > 0){
            return vet;
        }
        //verificar a existencia de inimigos
        
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Enemy){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                //adicionado na posição auxVetor.getx e na auxVetor.getY
            }
            return auxVetor;
        }
        // checa se tem amigos
        if(tab.getBlock(i,j).getBlockState(playing) == BlockState.Friend){
            return vet;
            
        }
        // checa se está vazio
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Empty){
            if(!vect.contains(tab.getBlock(auxVetor))){
                // se ele não existe, adiciiona na lista
                
            }
        }
        // condição de parada com o num
        if(num == 0){
             return vet;
        }else{
            return behindBlocks(xGo,yGo, vet, num--);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
