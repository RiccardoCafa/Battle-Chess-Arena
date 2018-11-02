
import businessPack.IPowerForPieces;
import businessPack.Piece;
import businessPack.Tabuleiro;
import javafx.scene.image.Image;


public class Horse extends Piece implements IPowerForPieces {

    public Horse(String n, Image im, int heal, boolean al, int pd) {
        super(n, im, heal, al, pd);
    }
    
    @Override
    public void superPower() {
        
    }
    @Override
    public void Move(){
        
    }

    @Override
    public void CheckMovePossibility(Tabuleiro tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
