package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Peon extends Piece {
    //atributos>>
    ItypePeon tpPeon;
    //construtor>>
    public Peon(ItypePeon tpPeon, TypeHero tpHero, int x, int y, Image image) {
        super(TypePiece.peon, tpHero, 8, 1, x, y, image);
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