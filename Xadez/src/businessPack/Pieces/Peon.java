package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultPeon;
import businessPack.Pieces.Huebr.huebrPeon;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;
import javafx.scene.image.Image;

public class Peon extends Piece {
    //atributos>>
    //construtor>>
    public Peon(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 2;
        strategy = getHeroStrategy();//new DefaultPeon();
        updateImage();
    }
    /*public Peon(Player pPiece, TypeHero tpHero, int x, int y, ItypePeon tpPeon) {
        super(pPiece, tpHero, x, y);
        hp = 2;
        this.tpPeon = tpPeon;
        updateImage();
    }*/
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay != null) freeWay.clear();
//        table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Peon.png", widhtImg, heightImg, false, false));
    }
    private ItypePiece getHeroStrategy() {
        switch(tpHero) {
            case huebr:
                return new huebrPeon();
            default:
                return new DefaultPeon(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypePeon(ItypePiece tpPeon){//muda o comportamento do checkMove()
        strategy = tpPeon;
    }
}