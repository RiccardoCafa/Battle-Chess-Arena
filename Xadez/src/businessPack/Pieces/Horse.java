package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Horse extends Piece {
    //atributos>>
    ItypeHorse tpHorse;
    //construtor>>
    public Horse(ItypeHorse tpHorse, TypeHero tpHero, int x, int y, Image image) {
        super(TypePiece.horse, tpHero, 6, 1, x, y, image);
        this.tpHorse = tpHorse;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpHorse.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeHorse(ItypeHorse tpHorse){//muda o comportamento do checkMove()
        this.tpHorse = tpHorse;
    }
}