package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Bishop extends Piece {
    //atributos>>
    ItypeBishop tpBishop;
    //construtor>>
    public Bishop( PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, hp, damage, x, y, image);
        tpPiece = TypePiece.bishop;
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpBishop.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeBishop(ItypeBishop tpBishop){//muda o comportamento do checkMove()
        this.tpBishop = tpBishop;
    }
}