package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Queen extends Piece {
    //atributos>>
    ItypeQueen tpQueen;
    //construtor>>
    public Queen(ItypeQueen tpQueen, boolean alive, int x, int y, Image image) {
        super(typePiece.queen, alive, 8, 1, x, y, image);
        this.tpQueen = tpQueen;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       tpQueen.IcheckMove(table);
    }
    //getset>>
    public void setTypeQueen(ItypeQueen tpQueen){//muda o comportamento do checkMove()
        this.tpQueen = tpQueen;
    }
}