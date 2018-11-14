package businessPack.Pieces;

import businessPack.TypePiece;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Tower extends Piece {
    //atributos>>
    private ItypeTower tpTower;
    private ItypeTower defaultTower;
    //construtor>>
    public Tower(PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image) {
        super(pPiece, tpHero, hp, damage, x, y, image);
        tpPiece = TypePiece.tower;
        tpTower = new DefaultTower();
        defaultTower = tpTower;
    }
    public Tower(PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image, ItypeTower typeTower) {
        super(pPiece, tpHero, hp, damage, x, y, image);
        tpPiece = TypePiece.tower;
        tpTower = typeTower;
        defaultTower = tpTower;
    }

    public Tower(Player p1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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