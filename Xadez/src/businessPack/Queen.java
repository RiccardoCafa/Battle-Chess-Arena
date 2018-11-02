/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack;

import javafx.scene.image.Image;

/**
 *
 * @author falca
 */
public class Queen extends Piece implements IPowerForPieces {
    
    public Queen(String n, Image im, int heal, boolean al, int pd){
        super(n,im,heal,al, pd);
    }
    
    @Override
    public void Move(){
        
    }

    @Override
    public void superPower() {

    }
}
