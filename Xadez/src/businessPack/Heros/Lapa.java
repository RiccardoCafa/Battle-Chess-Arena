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
import extras.Who;
import businessPack.TypeHero;
import javafx.scene.image.Image;
public class Lapa extends Hero {
    Image lapaTowerImage;
    Image lapaBishopImage;
    Image lapaPeonImage;
    Image lapaKingImage;
    Image lapaQueenImage;
    Image lapaHorseImage;
    public Lapa() {
        image = new Image(path + "lapa-01.png", widthImg, heightImg, false, false);
    }

    @Override
    public void createArmy(Army army, int sentido, Who jogador) {
         for(int k = 0;k<8;k++){
            army.addPiece(new Peon(jogador, TypeHero.lapa, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Tower(jogador, TypeHero.lapa, 0, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.lapa, 1, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lapa, 2, (int)(3.5 + sentido*3.5)));
        army.addPiece(new King(jogador , TypeHero.lapa, 3, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Queen(jogador , TypeHero.lapa, 4, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lapa, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.lapa, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.lapa, 7, (int)(3.5 + sentido*3.5)));
    }

    
    //LapaGod
}
