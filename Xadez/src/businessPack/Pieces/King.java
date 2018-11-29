package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultKing;
import businessPack.Pieces.Sheriff.SheriffKing;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Pistol;
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
//    public King(Player pPiece, TypeHero tpHero, int x, int y, ItypeKing tpKing) {
//        super(pPiece, tpHero, x, y);
//        hp = 18;
//        this.tpKing = tpKing;
//        updateImage();
//    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null) freeWay.clear();
        table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                shoot = new SheriffKing(Players.getPlayer(player));
                bullet[0] = new ImageView(new Image("InterfaceView/imagens/bullet.png", 13, 30, false, false));
                bullet[0].setFitWidth(13);
                bullet[0].setFitHeight(30);
                bullet[1] = new ImageView(new Image("InterfaceView/imagens/bullet.png", 13, 30, false, false));
                bullet[1].setFitWidth(13);
                bullet[1].setFitHeight(30);
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
    public ImageView getBullet2(){
        return bullet[1];
    }
}