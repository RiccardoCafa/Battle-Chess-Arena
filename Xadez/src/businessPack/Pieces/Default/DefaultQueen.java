package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.Movement;

public class DefaultQueen implements Movement {
    Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public DefaultQueen(Player playing){
        this.playing = playing;
    }
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        moveInf(1,0, vetor);
        moveInf(0,1, vetor);
        moveInf(-1,0, vetor);
        moveInf(0,-1, vetor);
        moveInf(1,1, vetor);
        moveInf(1,-1, vetor); //infinito e além
        moveInf(-1,1, vetor);
        moveInf(-1,-1, vetor);
        return vector;
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
        return newVetor;
    }
}