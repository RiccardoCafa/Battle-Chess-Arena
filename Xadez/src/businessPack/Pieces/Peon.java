package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Peon extends Piece {
    //atributos>>
    ItypePeon tpPeon;
    //construtor>>
    public Peon(ItypePeon tpPeon, boolean alive, int x, int y, Image image) {
        super(typePiece.peon, alive, 2, 1, x, y, image);
        this.tpPeon = tpPeon;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       tpPeon.IcheckMove(table);
    }
    //getset>>
    public void setTypePeon(ItypePeon tpPeon){//muda o comportamento do checkMove()
        this.tpPeon = tpPeon;
    }
}