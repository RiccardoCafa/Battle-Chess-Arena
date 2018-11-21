package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Tower;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;
import javafx.scene.image.Image;

public class Lenin extends Hero {
    //atributos>>
    Image leninTowerImage;
    Image LeninBishopImage;
    Image LeninPeonImage;
    Image LeninKingImage;
    Image LeninQueenImage;
    Image LeninHorseImage;
    //construtor>>
    public Lenin() {
        image = new Image(path + "lenin-01.png", widthImg, heightImg, false, false);
        tpHero = TypeHero.lenin;
    }

    //metodos>>
    @Override
    public void createArmy(Army army, int sentido, Who jogador){
        this.player = Players.getPlayer(jogador);
        for(int k = 0;k<8;k++){
            army.addPiece(new Peon(jogador, TypeHero.lenin, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Tower(jogador, TypeHero.lenin, 0, (int)(3.5 + sentido*2.5)));
        army.addPiece(new Horse(jogador , TypeHero.lenin, 1, (int)(3.5 + sentido*2.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lenin, 2, (int)(3.5 + sentido*2.5)));
        army.addPiece(new King(jogador , TypeHero.lenin, 3, (int)(3.5 + sentido*2.5)));
        army.addPiece(new Queen(jogador , TypeHero.lenin, 4, (int)(3.5 + sentido*2.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lenin, 5, (int)(3.5 + sentido*2.5)));
        army.addPiece(new Horse(jogador , TypeHero.lenin, 6, (int)(3.5 + sentido*2.5)));
        army.addPiece(new Tower(jogador , TypeHero.lenin, 7, (int)(3.5 + sentido*2.5)));
    }

    @Override
    public void GameManager(Table tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

}