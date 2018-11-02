/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack.Pecas;

import businessPack.IPowerForPieces;
import businessPack.Piece;
import businessPack.Tabuleiro;
import javafx.scene.image.Image;

/**
 *
 * @author falca
 */
public class Horse extends Piece implements IPowerForPieces {

    public Horse(String n, Image im, int heal, boolean al) {
        super(n, im, heal, al);
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
