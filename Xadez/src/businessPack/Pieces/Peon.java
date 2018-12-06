package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultPeon;
import businessPack.Pieces.Huebr.huebrPeon;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Who;
import javafx.scene.image.Image;
import businessPack.Pieces.Sheriff.SheriffPeon;
import businessPack.Pieces.Interfaces.IMovement;


public class Peon extends Piece {

    
    //atributos>>
    private boolean firstMove=true;
    //construtor>>
    public Peon(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        hp = 2;
        strategy = getHeroStrategy();//new DefaultPeon();
        tpPiece = TypePiece.peon;
        pieceName = "Peão";
        if(tpHero == TypeHero.huebr){
            hp = 6;
        }
        maxHp = hp;
        updateImage();
    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!= null)freeWay.clear();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Peon.png", widhtImg, heightImg, false, false));
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case huebr:
                especial = true;
                return new huebrPeon(Players.getPlayer(player));
            case sheriff:
                shoot = new SheriffPeon(Players.getPlayer(player), bullet[0]);
                bullet[0].setVisible(true);
                return new DefaultPeon(Players.getPlayer(player));
            default:
                return new DefaultPeon(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypePeon(IMovement tpPeon){//muda o comportamento do checkMove()
        strategy = tpPeon;
    }
    public boolean getFirstmove(){
        return firstMove;
    }
    public void setFirstmove(boolean move){
        this.firstMove = move;  
    }
}