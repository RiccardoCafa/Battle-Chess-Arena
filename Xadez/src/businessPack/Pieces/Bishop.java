package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Piece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Bishop extends Piece {
    //atributos>>
    ItypeBishop tpBishop;
    //construtor>>
    public Bishop(ItypeBishop tpBishop, boolean alive, int x, int y, Image image) {
        super(typePiece.bishop, alive, 4, 1, x, y, image);
        this.tpBishop = tpBishop;
    }
    //metodos>>
    @Override
    public ArrayList<Vetor> checkMove(Table table) {
       return tpBishop.IcheckMove(table);
    }
    //getset>>
    public void setTypeBishop(ItypeBishop tpBishop){//muda o comportamento do checkMove()
        this.tpBishop = tpBishop;
    }
}