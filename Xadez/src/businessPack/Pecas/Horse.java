package businessPack.Pecas;

import businessPack.Direcao;
import businessPack.IPowerForPieces;
import businessPack.Piece;
import businessPack.Tabuleiro;
import businessPack.direcao;
import javafx.scene.image.Image;


public class Horse extends Piece implements IPowerForPieces {

    public Horse(String n, Image im, int heal, boolean al, int pd) {
        super(n, im, heal, al, pd);
    }
    
    public Horse(String n, Image im, int heal, int pd) {
        super(n, im, heal, pd);
    }
    
    public Horse(String n, int heal, int pd) {
        super(n, heal, pd);
    }
    
    @Override
    public void superPower() {
        
    }
    public void MoveHorse(Direcao direction){
        
    }
    @Override
    public void Move(){
        
    }

    @Override
    public void CheckMovePossibility(Tabuleiro tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
