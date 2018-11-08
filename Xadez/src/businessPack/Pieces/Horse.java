package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Horse extends Piece {
    //atributos>>
    ItypeHorse tpHorse;
    //construtor>>
    public Horse(ItypeHorse tpHorse, boolean alive, int x, int y, Image image) {
        super(TypePiece.horse, alive, 6, 1, x, y, image);
        this.tpHorse = tpHorse;
    }
    //metodos>>
    @Override
    public ArrayList<Vetor> checkMove(Table table) {
       return tpHorse.IcheckMove(table);
    }
    //getset>>
    public void setTypeHorse(ItypeHorse tpHorse){//muda o comportamento do checkMove()
        this.tpHorse = tpHorse;
    }
}