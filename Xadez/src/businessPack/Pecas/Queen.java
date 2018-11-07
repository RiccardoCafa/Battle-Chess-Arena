package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Queen extends Piece {
    //construtor>>
    public Queen(boolean alive, int x, int y, Image image) {
        super(typePiece.queen, alive, 12, 1, x, y, image);
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       
    }
}