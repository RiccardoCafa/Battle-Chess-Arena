package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultQueen;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;

public class Queen extends Piece {
    //atributos>>
    ItypeQueen tpQueen;
    //construtor>>
    public Queen(Who pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 8;
        damage = 1;
        tpQueen = new DefaultQueen();
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