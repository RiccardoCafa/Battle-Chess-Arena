
package businessPack.Pecas;


import businessPack.Piece;
import businessPack.Tabuleiro;
import javafx.scene.image.Image;


public class Peon extends Piece {

    public Peon(String n, Image im, int heal, boolean al, int pd) {
        super(n, im, heal, al, pd);
    }
    
    public Peon(String n, Image im, int heal, int pd) {
        super(n, im, heal, pd);
    }
    
    public Peon(String n, int heal, int pd) {
        super(n, heal, pd);
    }
    
    @Override
    public void Move(){
        String a = "nothing";
        
    }

    @Override
    public void CheckMovePossibility(Tabuleiro tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
