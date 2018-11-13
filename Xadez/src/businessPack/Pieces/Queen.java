package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultQueen;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;

public class Queen extends Piece {
    //atributos>>
    ItypeQueen tpQueen;
    //construtor>>
<<<<<<< HEAD
    public Queen(PlayerPiece pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 8;
        damage = 1;
        tpQueen = new DefaultQueen();
=======
    public Queen( PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, x, y);
        tpPiece = TypePiece.queen;
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
>>>>>>> master
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