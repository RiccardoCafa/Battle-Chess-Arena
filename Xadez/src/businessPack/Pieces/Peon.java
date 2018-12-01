package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultPeon;
import businessPack.Pieces.Huebr.huebrPeon;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Who;
import javafx.scene.image.Image;
import businessPack.Pieces.Sheriff.SheriffPeon;
import businessPack.Pieces.Sheriff.Pistol;
import businessPack.Pieces.Interfaces.IMovement;
import javafx.scene.image.ImageView;

public class Peon extends Piece {
    //atributos>>
    //construtor>>
    public Peon(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 2;
        strategy = getHeroStrategy();//new DefaultPeon();
        tpPiece = TypePiece.peon;
        pieceName = "Peão";
        maxHp = hp;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!= null)freeWay.clear();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Peon.png", widhtImg, heightImg, false, false));
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case huebr:
                especial = true;
                return new huebrPeon(Players.getPlayer(player));
            case sheriff:
                shoot = new SheriffPeon(Players.getPlayer(player), bullet[0]);
                bullet[0].setVisible(true);
                return new DefaultPeon(Players.getPlayer(player));
            default:
                return new DefaultPeon(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypePeon(IMovement tpPeon){//muda o comportamento do checkMove()
        strategy = tpPeon;
    }
}