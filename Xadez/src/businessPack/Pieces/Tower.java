package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeTower;
import businessPack.Piece;
import businessPack.Table;
import javafx.scene.image.Image;

public class Tower extends Piece {
    //atributos>>
    private ItypeTower tpTower;
    //construtor>>
    public Tower(ItypeTower tpTower, boolean alive, int x, int y, Image image) {
        super(typePiece.tower, alive, 10, 1, x, y, image);
        this.tpTower = tpTower;
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
       tpTower.IcheckMove(table);
    }
    //getset>>
    public void setTypeTower(ItypeTower tpTower){//muda o comportamento do checkMove()
        this.tpTower = tpTower;
    }
}