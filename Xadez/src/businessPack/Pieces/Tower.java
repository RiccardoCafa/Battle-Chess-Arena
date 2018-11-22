package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Players;
import businessPack.TypePiece;
import extras.Who;

public class Tower extends Piece {
    //atributos>>
    //construtor>>
    public Tower(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 10;
        damage = 1;
        strategy = getHeroStrategy();//new DefaultTower(pPiece);
        tpPiece = TypePiece.tower;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay != null) freeWay.clear();
        //table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Tower.png",widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
    @Override
    public ItypePiece getHeroStrategy() {
        switch(tpHero) {
            case lapa:
                especial = true;
                return new LapaTower(Players.getPlayer(player));
            default:
                return new DefaultTower(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypeTower(ItypePiece tpTower){//muda o comportamento do checkMove()
        strategy = tpTower;
    }
}