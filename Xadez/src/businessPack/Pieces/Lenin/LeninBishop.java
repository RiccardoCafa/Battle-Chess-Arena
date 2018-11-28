    
package businessPack.Pieces.Lenin;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.IMovement;


public class LeninBishop implements IMovement{
    Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public LeninBishop(Player playing){
        this.playing = playing;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        move(1, 0, vetor);
        move(-1, 0, vetor);
        moveInf(-1, 1, vetor);
        moveInf(-1, -1, vetor);
        move(0, -1, vetor);
        move(0, 1, vetor); //infinito e além
        moveInf(1, 1, vetor);
        moveInf(1, -1, vetor);
        System.out.println("Eu sou lenin");
        return vector;
    }
    public void move(int xDir, int yDir, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return;
        
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return;
        }
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
    }
      public Vetor moveInf(int xDir, int yDir, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return vetor;
        
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return newVetor;
        }
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
            return moveInf(xDir, yDir, newVetor);
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
        return newVetor;
    }
}
