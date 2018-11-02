/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack;

import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class Exercito {
    private ArrayList<Piece> listPiecesDead;
    private ArrayList<Piece> army;

    public Exercito() {
        this.listPiecesDead = new ArrayList<>();
        this.army = new ArrayList<>();
    }
    
    public void addPieceToArmy(Piece e) {
        army.add(e);
    }
    
}

 
   

