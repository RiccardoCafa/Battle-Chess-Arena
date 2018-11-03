package businessPack.Pecas;

import businessPack.IPowerForPieces;
import businessPack.Piece;
import businessPack.Tabuleiro;
import javafx.scene.image.Image;


public class Tower extends Piece implements IPowerForPieces {    

    public Tower(String n, Image im, int heal, boolean al, int pd) {
        super(n, im, heal, al, pd);
    }
    
    public Tower(String n, Image im, int heal, int pd) {
        super(n, im, heal, pd);
    }
    
    public Tower(String n, int heal, int pd) {
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
        
    }
    
    
}
