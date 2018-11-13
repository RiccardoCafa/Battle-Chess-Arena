package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeKing;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultKing;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;

public class King extends Piece {
    //atributos>>
    ItypeKing tpKing;
    //construtor>>
<<<<<<< HEAD
    public King(PlayerPiece pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 18;
        damage = 1;
        tpKing = new DefaultKing();
    }
    public King(PlayerPiece pPiece, TypeHero tpHero, int x, int y, ItypeKing tpKing) {
        super(pPiece, tpHero, x, y);
        hp = 18;
        damage = 1;
        this.tpKing = tpKing;
=======
    public King( PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, x, y);
        tpPiece = TypePiece.King;
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
>>>>>>> master
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpKing.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeKing(ItypeKing tpKing){//muda o comportamento do checkMove()
        this.tpKing = tpKing;
    }
}