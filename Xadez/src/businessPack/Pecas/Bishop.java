package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Bishop extends Piece {
    //construtor>>
    public Bishop(boolean alive, int x, int y, Image image) {
        super(typePiece.bishop, alive, 4, 1, x, y, image);
    }
    //metodos>>
    /* String a = "nothing";//deixei de recordação :D */
    @Override
    public void checkMove(Table table) {
        
    }
}