package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Tower extends Piece {    
    //construtor>>
    public Tower(boolean alive, int x, int y, Image image) {
        super(typePiece.tower, alive, 10, 1, x, y, image);
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       
    }
}