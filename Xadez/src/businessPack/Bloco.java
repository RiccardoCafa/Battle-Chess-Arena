/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.image.Image;

/**
 *
 * @author patri
 */
public class Bloco {
    
    Piece myPiece;
    Vec2d pos;
    Image imageBloco;
    
    public Bloco() {
        myPiece = null;
    }
    
    public Bloco(Piece p) {
        myPiece = p;
    }
    
    public boolean CheckEmpty(){
        return myPiece == null;
    }
}
