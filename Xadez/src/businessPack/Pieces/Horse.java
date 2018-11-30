package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Pieces.Sheriff.SheriffHorse;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Pistol;
import extras.Who;
import javafx.scene.image.Image;
import businessPack.Pieces.Interfaces.IMovement;
import javafx.scene.image.ImageView;

public class Horse extends Piece {
    //atributos>>
    //construtor>>
    public Horse(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 6;
        strategy = getHeroStrategy();//new DefaultHorse(player);
        updateImage();
        pieceName = "Cavalo";
        maxHp = hp;
        tpPiece = TypePiece.horse;
    }
//    public Horse(Player player, TypeHero tpHero, int x, int y, ItypeHorse tpHorse) {
//        super(player, tpHero, x, y);
//        hp = 6;
//        this.tpHorse = tpHorse;
//        updateImage();
//    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay != null) freeWay.clear();
        //table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Horse.png", widhtImg, heightImg, false, false));
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                especial = true;
                shoot = new SheriffHorse(Players.getPlayer(player), bullet[0]);
                bullet[0].setVisible(true);
                return (IMovement) shoot;
            default:
                return new DefaultHorse(Players.getPlayer(player));
        }
    }
    @Override
    public void recharge(){
        shoot.recharge();
    }
    //getset>>
    public void setTypeHorse(IMovement tpHorse){//muda o comportamento do checkMove()
        strategy = tpHorse;
    }
}