package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeHorse;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultHorse;
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
        damage = 1;
        tpHorse = new DefaultHorse(player);
        updateImage();
    }
    public Horse(Player player, TypeHero tpHero, int x, int y, ItypeHorse tpHorse) {
        super(player, tpHero, x, y);
        hp = 6;
        damage = 1;
        this.tpHorse = tpHorse;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!= null)freeWay.clear();
//        table.clearTrend();
        freeWay = tpHorse.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Horse.png", 58, 130, false, false));  
    }
    //getset>>
    public void setTypeHorse(ItypeHorse tpHorse){//muda o comportamento do checkMove()
        this.tpHorse = tpHorse;
    }
}