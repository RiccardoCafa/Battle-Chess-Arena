package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Tower extends Piece {
    //atributos>>
    private ItypeTower tpTower;
    //construtor>>
    public Tower(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 10;
        damage = 1;
        tpTower = getHeroStrategy();//new DefaultTower(pPiece);
        updateImage();
    }
    /*public Tower(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 10;
        this.tpTower = tpTower;
        updateImage();
    }*/
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay != null) freeWay.clear();
        //table.clearTrend();
        freeWay = tpTower.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Tower.png",widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
    private ItypeTower getHeroStrategy() {
        switch(tpHero) {
            case lapa:
                return new LapaTower(player);
            default:
                return new DefaultTower(player);
        }
    }
    //getset>>
    public void setTypeTower(ItypeTower tpTower){//muda o comportamento do checkMove()
        this.tpTower = tpTower;
    }
}