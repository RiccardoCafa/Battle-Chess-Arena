package businessPack.Pieces.Lapa;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

/**
 *
 * @author ricca
 */
public class LapaTower implements ItypeTower {

    Player player;
    int casasOffSet;
    int count;
    Table table;
    
    public LapaTower(Player player) {
        this.player = player;
    }

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        ArrayList<Block> myMoves = new ArrayList<Block>();
        this.table = table;
        // Checa em cima dele quantas casas estão livres
        LookForLast(0, -1, vetor);
        LookForLast(0, 1, vetor);
        return null;
    }
    
    public Vetor LookForLast(int xDirection, int yDirection, Vetor vetor) {
        Vetor newVetor;
        int i = vetor.getX() + xDirection;
        int j = vetor.getY() + yDirection;
        newVetor = new Vetor(i, j);
        int xMax = xDirection == 1 ? Table.getM() - 1 : 0;
        int yMax = yDirection == 1 ? Table.getN() - 1 : 0;
        //System.out.println(table.getM() + " " + table.getN());
        if(xDirection == 0) {
            // MAXIMIUM PEGANDO TAMANHO DO TABULEIRO, CORRIGIR
            if((yMax == 0 && j < yMax) || (yMax == Table.getN()-1 && j >= yMax)) {
                System.out.println("Última posiçao encontrada em: " + vetor.getX() + " " + vetor.getY());
                return vetor;
            }
        } else if(yDirection == 0) {
            if((xMax == 0 && i < xMax) || (xMax == Table.getM()-1 && i >= xMax)) {
                System.out.println("Última posiçao encontrada em: " + vetor.getX() + " " + vetor.getY());
                return vetor;
            }
        }
        
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Enemy) {
            //FOR TEST DELETE THIS AFTER
            System.out.println("Enemy Found at: " + newVetor.getX() + " " + newVetor.getY());
            return newVetor;
        }
    
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Friend) {
            //FOR TEST DELETE THIS AFTER
            System.out.println("Friend Found at: " + newVetor.getX() + " " + newVetor.getY());
            return vetor;
        }
        
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Empty) {
            //FOR TEST DELETE THIS AFTER
            System.out.println("Looking more deeply, posicao : " + newVetor.getX() + " " + newVetor.getY());
            return LookForLast(xDirection, yDirection, newVetor);
        }
        //FOR TEST DELETE THIS AFTER
        System.out.println(newVetor.getX() + " " + newVetor.getY());
        return newVetor;
    }
    
    
}
