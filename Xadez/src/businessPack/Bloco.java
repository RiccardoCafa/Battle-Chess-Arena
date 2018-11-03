
package businessPack;

import javafx.scene.image.Image;
import com.sun.javafx.geom.Vec2d;


public class Bloco {
    Piece myPiece;
    Vec2d pos;
    Image imageBloco;

// test
    public Bloco(Piece p) {
        myPiece = p;
    } 

    Bloco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean CheckEmpty(){
        return myPiece == null;
    }
     public Image getMyImage(Image imageBloco){
        return imageBloco;
    }
}
