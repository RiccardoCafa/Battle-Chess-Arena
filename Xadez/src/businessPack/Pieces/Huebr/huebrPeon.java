/*ss
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack.Pieces.Huebr;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.IMovement;


public class huebrPeon implements IMovement {
    Player player;
    ArrayList<Block> freeWay;
    Table tab;
    int sentido;
    ArrayList<Block> vector;
  
    public huebrPeon(Player player){
        this.player = player;
        sentido = player.getSentido();   
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        vector = new ArrayList<>();
        this.tab = table;
        moveFront(0, -sentido, vetor,2);
        moveFront(0, sentido, vetor, 1);
        moveEnemy(1, -1, vetor);
        moveEnemy(1, 1, vetor);
        moveEnemy(-1, -1, vetor);
        moveEnemy(-1, 1, vetor);
        return vector;

    }
     public Vetor moveFront(int xDir, int yDir, Vetor vetor, int count) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7 || count <= 0 ) return vetor;
        
        if(tab.getBlock(newVetor).getBlockState(player) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return newVetor;
        }
        if(tab.getBlock(newVetor).getBlockState(player) == BlockState.Empty) {
            vector.add(tab.getBlock(newVetor));
            count = count - 1;
            System.out.println(count);
            return moveFront(xDir, yDir, newVetor, count);
        }
        return newVetor;
    }
     
     public void moveEnemy(int xDir, int yDir, Vetor vetor) {
        //tab.getBlock(vetor).getPiece().getTpHero() != tab.getBlock(vetor).getPiece().getTpHero()
        Vetor newVetor = new Vetor(vetor.getX() + xDir, vetor.getY() + yDir);
        int i = newVetor.getX(); int j = newVetor.getY();
        if(i < 0 || i > 7 || j < 0 || j > 7) return;
        
        if(tab.getBlock(newVetor).getBlockState(player) == BlockState.Enemy) {
            vector.add(tab.getBlock(newVetor));
            return;
        }
        System.out.println("Adicinado na posicao: " + newVetor.getX() + " " + newVetor.getY());
    }
    
}

  