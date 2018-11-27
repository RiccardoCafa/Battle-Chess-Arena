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
        moveSet(-1, 1, vetor);
        moveSet(-1, -1, vetor);
        moveSet(1, 1, vetor);
        moveSet(1, -1, vetor);
        return vect;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
    
    public Vetor moveSet(int xGo, int yGo, Vetor vet){
        Vetor auxVetor = new Vetor(vet.getX()+xGo, vet.getY()+yGo);
        int a = auxVetor.getX();
        int b = auxVetor.getY();
        if(a < 0 || a > 7 || b < 0 || b > 7){
            return vet;
        }
        if(tab.getBlock(auxVetor).getBlockState(playing) == BlockState.Enemy){
            
            vect.add(tab.getBlock(auxVetor));
            //lookBack(xGo,yGo,vet);
            return auxVetor;
        }
        //declaro aqui que recursividade é bonitão
        if(tab.getBlock(auxVetor).getBlockState(playing) ==  BlockState.Empty){
            vect.add(tab.getBlock(auxVetor));
            //lookBack(xGo,yGo,vet);
            return moveSet(xGo, yGo, vet);
        }
        return auxVetor;
    }
    public Vetor lookBack(int xAt, int yAt, Vetor vetAtual){
        Vetor auxVetor = new Vetor(vetAtual.getX()+xAt, vetAtual.getY()+yAt);
        int a = auxVetor.getX();
        int b = auxVetor.getY();
        if(a < 0 || a > 7 || b < 0 || b > 7){
            return vetAtual;
        }else{
            moveSet(-1, 1, auxVetor);
            moveSet(-1, -1, auxVetor);
            moveSet(1, 1, auxVetor);
            moveSet(1, -1, auxVetor);
        return vetAtual;
        }
    }   
    
    
    
    
}
