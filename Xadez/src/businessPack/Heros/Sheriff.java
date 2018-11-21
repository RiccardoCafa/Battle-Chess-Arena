package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
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
import javafx.scene.image.Image;

public class Sheriff extends Hero {
    //atributos>>
    //construtor>>
    public Sheriff() {
        image = new Image(path + "pistoleiro-01.png", widthImg, heightImg, false, false);
        tpHero = TypeHero.sheriff;
    }
    //metodos>>
    @Override
    public void createArmy(Army army, int sentido, Who player){
        this.player = Players.getPlayer(player);
        for(int i = 0; i < 8; i++) {
            army.addPiece(new Peon(player, TypeHero.sheriff, i, (int)(3.5 + sentido*2.5)));//peões
        }
        army.addPiece(new Bishop(player, TypeHero.sheriff, 2, (int)(3.5 + sentido*3.5)));//bispos
        army.addPiece(new Bishop(player, TypeHero.sheriff, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new  Horse(player, TypeHero.sheriff, 1, (int)(3.5 + sentido*3.5)));//cavalos
        army.addPiece(new  Horse(player, TypeHero.sheriff, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new  Tower(player, TypeHero.sheriff, 0, (int)(3.5 + sentido*3.5)));//torres
        army.addPiece(new  Tower(player, TypeHero.sheriff, 7, (int)(3.5 + sentido*3.5)));
        army.addPiece(new   King(player, TypeHero.sheriff, 4, (int)(3.5 + sentido*3.5)));//rei
        army.addPiece(new  Queen(player, TypeHero.sheriff, 3, (int)(3.5 + sentido*3.5)));//rainha

    }

    @Override
    public void GameManager(Table tab) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("IIIIAHHHHH Sheriff Power");
    }
}