package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Piece;
import businessPack.Table;
import extras.Vetor;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Peon extends Piece {
    //atributos>>
    ItypePeon tpPeon;
    //construtor>>
    public Peon(ItypePeon tpPeon, boolean alive, int x, int y, Image image) {
        super(TypePiece.peon, alive, 2, 1, x, y, image);
        this.tpPeon = tpPeon;
    }
    //metodos>>
    @Override
    public ArrayList<Vetor> checkMove(Table table) {
       return tpPeon.IcheckMove(table);
    }
    //getset>>
    public void setTypePeon(ItypePeon tpPeon){//muda o comportamento do checkMove()
        this.tpPeon = tpPeon;
    }
}