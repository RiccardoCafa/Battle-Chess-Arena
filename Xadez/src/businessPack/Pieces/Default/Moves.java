package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class Moves {
    
    ArrayList<Block> vector;
    Table tab;
    Player playing;
    
    public Moves(ArrayList<Block> vector, Table tab, Player playing) {
        this.vector = vector;
        this.tab = tab;
        this.playing = playing;
    }
    
    public void moveForward(int xDir, int yDir, Vetor vetor, boolean onlyEnemy) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return;
        if(!onlyEnemy) {
            if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
                vector.add(tab.getBlock(newVetor));
            }
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
    }
    /*public void move(int xDir, int yDir, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return;
        
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return;
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
    }*/
    
    public ArrayList<Block> getMovesList() {
        return vector;
    }
    
}
