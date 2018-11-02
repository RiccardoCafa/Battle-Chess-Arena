
package businessPack;


import javafx.scene.image.Image;


public class Bispo extends Piece {
    
    public Bispo(String n, Image im, int heal, boolean al, int pd){
        super(n,im,heal,al, pd);
    }
        
    @Override
    public void Move(){
        //método para moveer as peças
        
    }

    @Override
    public void CheckMovePossibility(Tabuleiro tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
