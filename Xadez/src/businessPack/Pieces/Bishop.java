package businessPack.Pieces;

import businessPack.Piece;
import businessPack.Pieces.Default.DefaultBishop;
import businessPack.Pieces.Lenin.LeninBishop;
import businessPack.Pieces.Wizard.WizardBishop;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Who;
import javafx.scene.image.Image;
import businessPack.Pieces.Interfaces.IMovement;

public class Bishop extends Piece {
    //atributos>>
    //construtor>>
    public Bishop(Who who, TypeHero tpHero, int x, int y) {
        super(who, tpHero, x, y);
        strategy = getHeroStrategy();//new DefaultBishop(pPiece);  
        hp = 4;
        tpPiece = TypePiece.bishop;
        pieceName = "Bispo";
        maxHp = hp;
        updateImage();
        //this.tpBishop = tpBishop; // Isso não faz sentido nenhum... (Ricc) 
    }
//    public Bishop(Player pPiece, TypeHero tpHero, int x, int y, ItypeBishop tpBishop) {
//        super(pPiece, tpHero, x, y);
//        this.tpBishop = tpBishop;
//        hp = 4;
//        this.tpBishop = tpBishop;
//        updateImage();
//    }
    //metodos>>
    @Override
    public void checkMove(Table table) {
        if(freeWay!=null)freeWay.clear();
        //table.clearTrend();
        freeWay = strategy.IcheckMove(table, vetor);
        updateHitWay();
    }
    @Override
    public IMovement getHeroStrategy() {
        switch(tpHero) {
            case wizard:
                especial = true;
                return new WizardBishop();
            default:
                return new DefaultBishop(Players.getPlayer(player));
        }
    }
    //getset>>
    public void setTypeBishop(IMovement tpBishop){//muda o comportamento do checkMove()
        strategy = tpBishop;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Bishop.png", widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
}