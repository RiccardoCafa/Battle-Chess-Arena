package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Horse extends Piece {
    //construtor>>
    public Horse(boolean alive, int x, int y, Image image) {
        super(typePiece.horse, alive, 6, 1, x, y, image);
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       
    }
}