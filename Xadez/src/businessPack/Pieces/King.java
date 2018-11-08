package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class King extends Piece {
    //atributos>>
    ItypeKing tpKing;
    //construtor>>
    public King(ItypeKing tpKing, boolean alive, int x, int y, Image image) {
        super(typePiece.king, alive, 18, 1, x, y, image);
        this.tpKing = tpKing;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       tpKing.IcheckMove(table);
    }
}