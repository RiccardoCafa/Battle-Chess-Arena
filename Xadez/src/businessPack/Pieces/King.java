package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Piece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class King extends Piece {
    //atributos>>
    ItypeKing tpKing;
    //construtor>>
    public King(ItypeKing tpKing, boolean alive, int x, int y, Image image) {
        super(TypePiece.king, alive, 18, 1, x, y, image);
        this.tpKing = tpKing;
    }
    //metodos>>
    @Override
    public ArrayList<Vetor> checkMove(Table table) {
       return tpKing.IcheckMove(table);
    }
    //getset>>
    public void setTypeKing(ItypeKing tpKing){//muda o comportamento do checkMove()
        this.tpKing = tpKing;
    }
}