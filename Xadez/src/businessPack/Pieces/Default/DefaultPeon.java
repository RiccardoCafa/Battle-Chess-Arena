package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.IMovement;
import businessPack.Pieces.Peon;

public class DefaultPeon implements IMovement {
    //metodos>>
   Table tab;
    ArrayList<Block> vector;
    Player playing;
    Peon peon;
    
    /**
     *
     * @param playing - The player who the peon will take information to make some calculus.
     */
    public DefaultPeon(Player playing){
        this.playing = playing;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        tab = table;
        Peon p = (Peon) table.getBlock(vetor).getPiece();
        if(!p.getFirstmove()){
            move(0,-1*playing.getSentido(),vetor);
        } else {
            moveFrontDefault(0, -1 * playing.getSentido(), vetor,2);
        }
        
        moveEnemy(1,-1*playing.getSentido(),vetor);
        moveEnemy(-1,-1*playing.getSentido(),vetor);
        return vector;
    }

    /**
     *
     * @param xDir The direction on the Horizontal axis
     * @param yDir The direction on the Vertical axis
     * @param vetor The position that will start making calculus of the movement
     */
    public void move(int xDir, int yDir, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return;
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
        }
        //System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
    }
    public void moveEnemy(int xDir, int yDir, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return;
        
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return;
        }
    }
       
    /**
     *
     * @param xDir The direction on the Horizontal axis
     * @param yDir The direction on the Vertical axis
     * @param vetor The position that will start making calculus of the movement
     * @return Last position of the movement
     */
    public Vetor moveFrontDefault(int xDir, int yDir, Vetor vetor, int count) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7 || count <= 0 ) return vetor;
        if(tab.getBlock(newVetor).getBlockState(playing) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
            count = count - 1;
            System.out.println(count);
            return moveFrontDefault(xDir, yDir, newVetor, count);
        }
        return newVetor;
    }
     
}
