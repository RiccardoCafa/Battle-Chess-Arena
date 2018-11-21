package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultPeon implements ItypePiece {
    //metodos>>
       Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public DefaultPeon(Player playing){
        this.playing = playing;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        if(playing.getPlayingTurn()==1){
             move(0, 1, vetor);
             move(-1, 1,vetor);
             move(1, 1,vetor);
        }else{
             move(0, -1, vetor);
             move(1, -1,vetor);
             move(-1, -1,vetor);
        }
        //implementação da movimentação padrão do peão
        return null;
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