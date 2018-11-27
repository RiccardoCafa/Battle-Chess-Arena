package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.Movement;

public class DefaultKing implements Movement {
    Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public DefaultKing(Player playing){
        this.playing = playing;
    }
    //metodos>>
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        move(1, 0, vetor);
        move(-1, 0, vetor);
        move(-1, 1, vetor);
        move(-1, -1, vetor);
        move(0, -1, vetor);
        move(0, 1, vetor);
        move(1, 1, vetor);
        move(1, -1, vetor);
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

}