package businessPack.Pieces;

import businessPack.Pieces.Interfaces.ItypeBishop;
import businessPack.Piece;
import businessPack.Pieces.Default.DefaultBishop;
import businessPack.Pieces.Lenin.LeninBishop;
import businessPack.Pieces.Wizard.WizardBishop;
import businessPack.Player;
import businessPack.Table;
import businessPack.TypeHero;
import javafx.scene.image.Image;

public class Bishop extends Piece {
    //atributos>>
    ItypeBishop tpBishop;
    //construtor>>
    public Bishop(Player pPiece, TypeHero tpHero, int x, int y) {
        super(pPiece, tpHero, x, y);
        tpBishop = getHeroStrategy();//new DefaultBishop(pPiece);  
        hp = 4;
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
//        table.clearTrend();
        freeWay = tpBishop.IcheckMove(table, vetor);
        updateHitWay(table);
    }
    private ItypeBishop getHeroStrategy() {
        switch(tpHero) {
            case wizard:
                return new WizardBishop();
            case lenin:
                return new LeninBishop(player);
            default:
                return new DefaultBishop(player);
        }
    }
    //getset>>
    public void setTypeBishop(ItypeBishop tpBishop){//muda o comportamento do checkMove()
        this.tpBishop = tpBishop;
    }
    public void updateImage() {
        setImage(new Image("InterfaceView/imagens/" + pathHero + "Pieces/" + pathHero + "Bishop.png", widhtImg, heightImg, false, false));
        setMouseTransparent(true);
    }
}