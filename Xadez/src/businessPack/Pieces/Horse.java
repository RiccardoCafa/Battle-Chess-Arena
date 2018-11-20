package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Pieces.Sheriff.SheriffHorse;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;
import javafx.scene.image.Image;

public class Horse extends Piece {
    //atributos>>
    //construtor>>
    public Horse(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 6;
        strategy = getHeroStrategy();//new DefaultHorse(player);
        updateImage();
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
        if(freeWay!= null)freeWay.clear();
//        table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Horse.png", widhtImg, heightImg, false, false));
    }
    private ItypePiece getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                return new SheriffHorse(Players.getPlayer(player));
            default:
                return new DefaultHorse(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypeHorse(ItypePiece tpHorse){//muda o comportamento do checkMove()
        strategy = tpHorse;
    }
}