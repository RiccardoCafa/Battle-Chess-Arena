package businessPack.Pieces;

import businessPack.Block;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;
import businessPack.Players;
import businessPack.TypePiece;
import extras.Who;
import businessPack.Pieces.Sheriff.SheriffTower;
import businessPack.Pieces.Interfaces.IMovement;
import java.util.ArrayList;

public class Tower extends Piece {
    //atributos>>
    ArrayList<Block> sheriffTowerHitWay;
    //construtor>>
    public Tower(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 10;
        damage = 1;
        strategy = getHeroStrategy();//new DefaultTower(pPiece);
        tpPiece = TypePiece.tower;
        pieceName = "Torre";
        maxHp = hp;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay != null) freeWay.clear();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Tower.png",widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case lapa:
                especial = true;
                return new LapaTower(Players.getPlayer(player));
            case sheriff:
                shoot = new SheriffTower(Players.getPlayer(player));
                return new DefaultTower(Players.getPlayer(player));
            default:
                return new DefaultTower(Players.getPlayer(player));
        }
    }
    public ArrayList<Block> getSheriffTowerHitWay(Table table){
        if(tpHero == TypeHero.sheriff)
            return ((SheriffTower)shoot).sheriffTowerHitWay(table, vetor);
        return null;
    }
    //getset>>
    public void setTypeTower(IMovement tpTower){//muda o comportamento do checkMove()
        strategy = tpTower;
    }
}