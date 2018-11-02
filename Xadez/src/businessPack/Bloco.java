/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack;

import com.sun.javafx.geom.Vec2d;

/**
 *
 * @author patri
 */
public class Bloco {
    Piece mypiece;
    Vec2d pos;

    public boolean CheckEmpty(){
        return mypiece == null;
}
}
