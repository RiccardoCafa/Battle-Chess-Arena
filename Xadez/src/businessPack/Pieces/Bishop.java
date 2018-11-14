package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultBishop;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Bishop extends Piece {
    //atributos>>
    ItypeBishop tpBishop;
    //construtor>>
    public Bishop(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        tpBishop = new DefaultBishop();
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Bishop.png", 58, 130, false, false));  
        hp = 4;
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null)freeWay.clear();
//        table.clearTrend();
        freeWay = tpBishop.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeBishop(ItypeBishop tpBishop){//muda o comportamento do checkMove()
        this.tpBishop = tpBishop;
    }
}