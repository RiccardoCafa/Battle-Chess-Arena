/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPack.Pieces.Huebr;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class huebrPeon implements ItypePiece {


    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        return null;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
}