package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultKing;
import businessPack.Pieces.Sheriff.SheriffKing;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import businessPack.Pieces.Sheriff.Pistol;
import extras.Who;
import javafx.scene.image.Image;
import businessPack.Pieces.Interfaces.IMovement;
import businessPack.Pieces.Sheriff.SheriffTower;
import javafx.scene.image.ImageView;

public class King extends Piece {
    //atributos>>
    //construtor>>
    public King(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 18;
        damage = 1;
        strategy = getHeroStrategy();//new DefaultKing(player);
        tpPiece = TypePiece.king;
        pieceName = "Rei";
        maxHp = hp;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null) freeWay.clear();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                shoot = new SheriffKing(Players.getPlayer(player), bullet[0], bullet[1]);
                bullet[0].setVisible(true);
                bullet[1].setVisible(true);
                return new DefaultKing(Players.getPlayer(player));
            default:
                return new DefaultKing(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypeKing(IMovement tpKing){//muda o comportamento do checkMove()
        strategy = tpKing;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "King.png", widhtImg, heightImg, false, false));
    }
}