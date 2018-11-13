package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;

public class Horse extends Piece {
    //atributos>>
    ItypeHorse tpHorse;
    //construtor>>
    public Horse(PlayerPiece pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 6;
        damage = 1; 
        tpHorse = new DefaultHorse();
    }
    public Horse(PlayerPiece pPiece, TypeHero tpHero, int x, int y, ItypeHorse tpHorse) {
        super(pPiece, tpHero, x, y);
        hp = 6;
        damage = 1; 
        this.tpHorse = tpHorse;
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