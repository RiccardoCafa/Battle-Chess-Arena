package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Piece;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;

public class Bishop extends Piece {
    //atributos>>
    ItypeBishop tpBishop;
    //construtor>>
    public Bishop(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 4;
        this.tpBishop = tpBishop;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpBishop.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeBishop(ItypeBishop tpBishop){//muda o comportamento do checkMove()
        this.tpBishop = tpBishop;
    }
}