package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultQueen;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Sheriff.SheriffQueen;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;
import businessPack.Players;
import businessPack.TypePiece;
import extras.Who;
import businessPack.Pieces.Sheriff.Pistol;
import businessPack.Pieces.Interfaces.IMovement;

public class Queen extends Piece {
    //atributos>>
    //construtor>>
    public Queen(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 8;
        damage = 1;
        strategy = getHeroStrategy();
        tpPiece = TypePiece.queen;
        pieceName = "Rainha";
        maxHp = hp;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null)freeWay.clear();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    @Override
    public IMovement getHeroStrategy(){
        switch(tpHero) {
            case lenin:
                especial = true;
            case sheriff:
                shoot = new SheriffQueen(Players.getPlayer(player));
                return new DefaultQueen(Players.getPlayer(player));
            default:
                return new DefaultQueen(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypeQueen(IMovement tpQueen){//muda o comportamento do checkMove()
        strategy = tpQueen;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Queen.png", widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
}