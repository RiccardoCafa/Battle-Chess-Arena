package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Tower extends Piece {
    //atributos>>
    private ItypeTower tpTower;
    //construtor>>
    public Tower(PlayerPiece pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 10;
        damage = 1;
        tpTower = new DefaultTower();
    }
    public Tower(PlayerPiece pPiece, TypeHero tpHero, int x, int y, ItypeTower tpTower) {
        super(pPiece, tpHero, x, y);
        hp = 10;
        damage = 1;
        this.tpTower = tpTower;
        image = new Image("InterfaceView/imagens/lapaPieces/lapaTower.png", 58, 130, false, false);
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        freeWay.clear();
        table.clearTrend();
        freeWay = tpTower.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    //getset>>
    public void setTypeTower(ItypeTower tpTower){//muda o comportamento do checkMove()
        this.tpTower = tpTower;
    }
}