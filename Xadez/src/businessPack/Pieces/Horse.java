package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Pieces.Sheriff.SheriffHorse;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Horse extends Piece {
    //atributos>>
    ItypeHorse tpHorse;
    //construtor>>
    public Horse(Player player, TypeHero tpHero, int x, int y) {
        super(player, tpHero, x, y);
        hp = 6;
        tpHorse = getHeroStrategy();//new DefaultHorse(player);
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
        freeWay = tpHorse.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Horse.png", widhtImg, heightImg, false, false));
    }
    private ItypeHorse getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                return new SheriffHorse(player);
            default:
                return new DefaultHorse(player);
        }
    }
    //getset>>
    public void setTypeHorse(ItypeHorse tpHorse){//muda o comportamento do checkMove()
        this.tpHorse = tpHorse;
    }
}