package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeQueen;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultQueen;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Sheriff.SheriffQueen;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Queen extends Piece {
    //atributos>>
    ItypeQueen tpQueen;
    //construtor>>
    public Queen(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        hp = 8;
        damage = 1;
        tpQueen = new DefaultQueen(pPiece);
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null)freeWay.clear();
        //table.clearTrend();
        freeWay = tpQueen.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    private ItypeQueen getHeroStrategy() {
        switch(tpHero) {
            case sheriff:
                return new SheriffQueen(player);
            default:
                return new DefaultQueen(player);
        }
    }
    //getset>>
    public void setTypeQueen(ItypeQueen tpQueen){//muda o comportamento do checkMove()
        this.tpQueen = tpQueen;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Queen.png", widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
}