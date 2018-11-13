package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;

public class Horse extends Piece {
    //atributos>>
    ItypeHorse tpHorse;
    //construtor>>
    public Horse(Player player, TypeHero tpHero, int x, int y) {
        super(player, tpHero, x, y);
        hp = 6;
        damage = 1;
        tpHorse = new DefaultHorse(player);
    }
    public Horse(Player player, TypeHero tpHero, int x, int y, ItypeHorse tpHorse) {
        super(player, tpHero, x, y);
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