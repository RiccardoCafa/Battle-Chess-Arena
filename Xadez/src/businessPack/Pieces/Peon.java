package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultPeon;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;

public class Peon extends Piece {
    //atributos>>
    ItypePeon tpPeon;
    //construtor>>
    public Peon(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 2;
        tpPeon = new DefaultPeon();
    }
    public Peon(Player pPiece, TypeHero tpHero, int x, int y, ItypePeon tpPeon) {
        super(pPiece, tpHero, x, y);
        hp = 2;
        this.tpPeon = tpPeon;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpPeon.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypePeon(ItypePeon tpPeon){//muda o comportamento do checkMove()
        this.tpPeon = tpPeon;
    }
}