
package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Tabuleiro;
import javafx.scene.image.Image;




public class King extends Piece {
    
    public King(String n, Image im, int heal, boolean al){
        super(n,im,heal,al);
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
