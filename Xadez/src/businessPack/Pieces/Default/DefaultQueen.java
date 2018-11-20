package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultQueen implements ItypePiece {
    Table tab;
    ArrayList<Block> vector;
    Player playing;
    
    public DefaultQueen(Player playing){
        this.playing = playing;
    }
    //metodos>>
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        moveInf(Vetor.getTrend(1), vetor);
        moveInf(Vetor.getTrend(2), vetor);
        moveInf(Vetor.getTrend(3), vetor);
        moveInf(Vetor.getTrend(4), vetor);
        moveInf(Vetor.getTrend(5), vetor);
        moveInf(Vetor.getTrend(6), vetor); //infinito e além
        moveInf(Vetor.getTrend(7), vetor);
        moveInf(Vetor.getTrend(8), vetor);
        return vector;
    }
    public Vetor moveInf(Vetor versor, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + versor.getX(), vetor.getY() + versor.getY());
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return vetor;
        
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            Vetor vetAux = new Vetor(-versor.getX(), -versor.getY());
            tab.getBlock(newVetor).getVetor().setTrend(vetAux);
            return newVetor;
        }
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
            return moveInf(versor, newVetor);
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
        return newVetor;
    }
}