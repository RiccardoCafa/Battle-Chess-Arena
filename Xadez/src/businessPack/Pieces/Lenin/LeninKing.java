package businessPack.Pieces.Lenin;

import businessPack.Block;
import businessPack.Table;
import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Player;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;


public class LeninKing implements ItypeKing {
    Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public LeninKing(Player playing){
        this.playing = playing;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        this.tab = table;
        move(1, 0, vetor,2);
        move(-1, 0, vetor,2);
        move(-1, 1, vetor,2);
        move(-1, -1, vetor,2);
        move(0, -1, vetor,2);
        move(0, 1, vetor,2);
        move(1, 1, vetor,2);
        move(1, -1, vetor,2);
        
        
        return vector;

    }
     public Vetor move(int xDir, int yDir, Vetor vetor, int lefting) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7 || lefting <= 0 ) return vetor;
        
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return newVetor;
        }
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
            lefting = lefting - 1;
            System.out.println(lefting);
            return move(xDir, yDir, newVetor, lefting);
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
        return newVetor;
    }
    
}
