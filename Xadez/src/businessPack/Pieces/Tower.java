package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;

public class Tower extends Piece {
    //atributos>>
    private ItypeTower tpTower;
    private ItypeTower defaultTower;
    //construtor>>
    public Tower(PlayerPiece pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        tpPiece = TypePiece.tower;
        tpTower = new DefaultTower();
        defaultTower = tpTower;
    }
    public Tower(PlayerPiece pPiece, TypeHero tpHero, int x, int y, ItypeTower typeTower) {
        super(pPiece, tpHero, x, y);
        tpPiece = TypePiece.tower;
        tpTower = typeTower;
        defaultTower = tpTower;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        //freeWay.clear();
        //table.clearTrend();
        freeWay = tpTower.IcheckMove(table, vetor);
        //updateHitWay(table);
    }
    //getset>>
    public void setTypeTower(ItypeTower tpTower){//muda o comportamento do checkMove()
        this.tpTower = tpTower;
    }
    public void setDefaultType() {
        this.tpTower = defaultTower;
    }
}