package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Piece;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Sheriff extends Hero {
    //atributos>>
    ArrayList<Piece> bulletPieces;
    //construtor>>
    public Sheriff(){
        bulletPieces = new ArrayList<>();
        image = new Image(path + "pistoleiro-01.png", widthImg, heightImg, false, false);
        tpHero = TypeHero.sheriff;
    }
    //metodos>>
    @Override
    public void createArmy(Army army, int sentido, Who player){
        Piece sheriffPiece;
        this.player = Players.getPlayer(player);
        for(int i = 1; i < 7; i++){
            sheriffPiece = new Peon(player, TypeHero.sheriff, i, (int)(3.5 + sentido*2.5));
            bulletPieces.add(sheriffPiece);
            army.addPiece(sheriffPiece);//peões
        }
        sheriffPiece = new Bishop(player, TypeHero.sheriff, 2, (int)(3.5 + sentido*3.5));//bispo
        army.addPiece(sheriffPiece);//bispo
        sheriffPiece = new Bishop(player, TypeHero.sheriff, 5, (int)(3.5 + sentido*3.5));//bispo
        army.addPiece(sheriffPiece);//bispo
        sheriffPiece = new  Horse(player, TypeHero.sheriff, 1, (int)(3.5 + sentido*3.5));//cavalo
        bulletPieces.add(sheriffPiece);
        army.addPiece(sheriffPiece);//cavalo
        sheriffPiece = new  Horse(player, TypeHero.sheriff, 6, (int)(3.5 + sentido*3.5));//cavalo
        bulletPieces.add(sheriffPiece);
        army.addPiece(sheriffPiece);//cavalo
        sheriffPiece = new  Tower(player, TypeHero.sheriff, 0, (int)(3.5 + sentido*3.5));//torre
        bulletPieces.add(sheriffPiece);
        army.addPiece(sheriffPiece);//torre
        sheriffPiece = new  Tower(player, TypeHero.sheriff, 7, (int)(3.5 + sentido*3.5));//torre
        bulletPieces.add(sheriffPiece);
        army.addPiece(sheriffPiece);//torre
        sheriffPiece = new   King(player, TypeHero.sheriff, 4, (int)(3.5 + sentido*3.5));//rei
        bulletPieces.add(sheriffPiece);
        army.addPiece(sheriffPiece);//rei
        sheriffPiece = new  Queen(player, TypeHero.sheriff, 3, (int)(3.5 + sentido*3.5));//rainha
        bulletPieces.add(sheriffPiece);
        army.addPiece(sheriffPiece);//rainha
    }
    public void recharge(){
        for(Piece piece : bulletPieces){
            
        }
    }
    @Override
    public void GameManager(Table tab) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("IIIIAHHHHH Sheriff Power");
        return;
    }
}