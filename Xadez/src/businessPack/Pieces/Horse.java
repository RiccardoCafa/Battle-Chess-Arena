package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Horse extends Piece {
    //atributos>>
    ItypeHorse tpHorse;
    //construtor>>
    public Horse( PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, hp, damage, x, y, image);
        tpPiece = TypePiece.horse;
        //tpPiece = TypePiece.bishop; // Isso não faz sentido nenhum... (Ricc) 
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpHorse.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeHorse(ItypeHorse tpHorse){//muda o comportamento do checkMove()
        this.tpHorse = tpHorse;
    }
}