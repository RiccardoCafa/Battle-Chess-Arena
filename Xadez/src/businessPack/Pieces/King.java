package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultKing;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class King extends Piece {
    //atributos>>
    ItypeKing tpKing;
    //construtor>>
    public King(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 18;
        damage = 1;
        tpKing = new DefaultKing(player);
        updateImage();
    }
    public King(Player pPiece, TypeHero tpHero, int x, int y, ItypeKing tpKing) {
        super(pPiece, tpHero, x, y);
        hp = 18;
        this.tpKing = tpKing;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null) freeWay.clear();
        //table.clearTrend();
        freeWay = tpKing.IcheckMove(table, vetor);
        //updateHitWay(table);
    }
    //getset>>
    public void setTypeKing(ItypeKing tpKing){//muda o comportamento do checkMove()
        this.tpKing = tpKing;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "King.png", 58, 130, false, false));
    }
}