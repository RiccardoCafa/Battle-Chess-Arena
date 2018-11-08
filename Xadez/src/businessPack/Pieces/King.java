package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class King extends Piece {
    //atributos>>
    ItypeKing tpKing;
    //construtor>>
    public King(ItypeKing tpKing, TypeHero tpHero, int x, int y, Image image) {
        super(TypePiece.king, tpHero, 8, 1, x, y, image);
        this.tpKing = tpKing;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        freeWay = tpKing.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeKing(ItypeKing tpKing){//muda o comportamento do checkMove()
        this.tpKing = tpKing;
    }
}