package businessPack.Pecas;

import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Peon extends Piece {
    //construtor>>
    public Peon(boolean alive, int hp, int damage, int x, int y, Image image) {
        super(typePiece.peon, alive, hp, damage, x, y, image);
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       
    }
}