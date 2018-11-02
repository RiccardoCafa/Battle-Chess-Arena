
package businessPack;

import javafx.scene.image.Image;
import com.sun.javafx.geom.Vec2d;


public class Bloco {
    Piece myPiece;
    Vec2d pos;
    Image imageBloco;

    public Bloco() {
        myPiece = null;
    }
    
    public boolean CheckEmpty(){
        return myPiece == null;
    }
     public Image getMyImage(Image imageBloco){
        return imageBloco;
    }
}
