package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultTower implements ItypeTower {
    Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public DefaultTower(Player playing){
        this.playing = playing;
    }
    //metodos>>
    @Override
    public Table reaction(Table table, Vetor vetor) {
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        moveInf(1, 0, vetor);
        moveInf(-1, 0, vetor);
        moveInf(0, -1, vetor);
        moveInf(0, 1, vetor); //infinito e além
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
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
        return newVetor;
    }
}