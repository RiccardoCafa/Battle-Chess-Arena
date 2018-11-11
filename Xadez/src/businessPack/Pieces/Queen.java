package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Queen extends Piece {
    //atributos>>
    ItypeQueen tpQueen;
    //construtor>>
    public Queen(ItypeQueen tpQueen, TypeHero tpHero, int x, int y, Image image) {
        super(TypePiece.queen, tpHero, 8, 1, x, y, image);
        this.tpQueen = tpQueen;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpQueen.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeQueen(ItypeQueen tpQueen){//muda o comportamento do checkMove()
        this.tpQueen = tpQueen;
    }
}