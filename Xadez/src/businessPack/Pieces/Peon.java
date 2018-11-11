package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypePeon;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Peon extends Piece {
    //atributos>>
    ItypePeon tpPeon;
    //construtor>>
    public Peon( PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, hp, damage, x, y, image);
        tpPiece = TypePiece.peon;
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpPeon.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypePeon(ItypePeon tpPeon){//muda o comportamento do checkMove()
        this.tpPeon = tpPeon;
    }
}