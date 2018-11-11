package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Queen extends Piece {
    //atributos>>
    ItypeQueen tpQueen;
    //construtor>>
    public Queen( PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, hp, damage, x, y, image);
        tpPiece = TypePiece.queen;
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpQueen.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeQueen(ItypeQueen tpQueen){//muda o comportamento do checkMove()
        this.tpQueen = tpQueen;
    }
}