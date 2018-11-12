package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Tower;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.TypeHero;
import extras.PlayerPiece;
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
    public Lenin(Image image) {
        super(image);
    }
    //metodos>>
    @Override
    public void createArmy(Army army, int sentido,PlayerPiece jogador){
        for(int k = 0;k<8;k++){
            army.addPiece(new Peon(jogador, TypeHero.lenin, k, 10, 1, (int)(3.5 + sentido*2.5), LeninPeonImage));
        }
        army.addPiece(new Tower(jogador, TypeHero.lenin, 10, 1, 0, (int)(3.5 + sentido*2.5), leninTowerImage));
        army.addPiece(new Horse(jogador , TypeHero.lenin, 10, 1, 1, (int)(3.5 + sentido*2.5), LeninQueenImage));
        army.addPiece(new Bishop(jogador , TypeHero.lenin, 10, 1, 2, (int)(3.5 + sentido*2.5), LeninBishopImage));
        army.addPiece(new King(jogador , TypeHero.lenin, 10, 1, 3, (int)(3.5 + sentido*2.5), LeninKingImage));
        army.addPiece(new Queen(jogador , TypeHero.lenin, 10, 1, 4, (int)(3.5 + sentido*2.5), LeninQueenImage));
        army.addPiece(new Bishop(jogador , TypeHero.lenin, 10, 1, 5, (int)(3.5 + sentido*2.5), LeninBishopImage));
        army.addPiece(new Horse(jogador , TypeHero.lenin, 10, 1, 6, (int)(3.5 + sentido*2.5), LeninQueenImage));
        army.addPiece(new Tower(jogador , TypeHero.lenin, 10, 1, 7, (int)(3.5 + sentido*2.5), leninTowerImage));
        army.addPiece(new Tower(jogador , TypeHero.lenin, 10, 1, 0, 0, leninTowerImage));
    }

  

}