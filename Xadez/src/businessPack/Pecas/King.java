package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class King extends Piece {
    //construtor>>
    public King(boolean alive, int x, int y, Image image) {
        super(typePiece.king, alive, 18, 1, x, y, image);
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       
    }
}