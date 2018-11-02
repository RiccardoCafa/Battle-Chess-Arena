package businessPack;

import businessPack.IPowerForPieces;
import businessPack.Piece;
import businessPack.Tabuleiro;
import javafx.scene.image.Image;


public class Queen extends Piece implements IPowerForPieces {

    public Queen(String n, Image im, int heal, boolean al, int pd) {
        super(n, im, heal, al, pd);
    }
    
    public Queen(String n, Image im, int heal, int pd) {
        super(n, im, heal, pd);
    }
    
    public Queen(String n, int heal, int pd) {
        super(n, heal, pd);
    }
    
    @Override
    public void Move(){
        
    }

    @Override
    public void superPower() {

    }

    @Override
    public void CheckMovePossibility(Tabuleiro tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
