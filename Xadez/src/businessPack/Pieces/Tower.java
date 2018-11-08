package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Piece;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Tower extends Piece {
    //atributos>>
    private ItypeTower tpTower;
    //construtor>>
    public Tower(ItypeTower tpTower, TypeHero tpHero, int x, int y, Image image) {
        super(TypePiece.tower, tpHero, 8, 1, x, y, image);
        this.tpTower = tpTower;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        freeWay = tpTower.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeTower(ItypeTower tpTower){//muda o comportamento do checkMove()
        this.tpTower = tpTower;
    }
}