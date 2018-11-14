package businessPack.Heros;

import businessPack.Pieces.Huebr.huebrPeon;
import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Default.DefaultBishop;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Pieces.Default.DefaultKing;
import businessPack.Pieces.Default.DefaultQueen;
import businessPack.Pieces.Default.DefaultTower;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;


import businessPack.Pieces.Tower;
import extras.PlayerPiece;
import javafx.scene.image.Image;

public class Huebr extends Hero {

    Image huebrPeonImage;
    Image huebrBishopImage;
    Image huebrHorseImage;
    Image huebrTowerImage;
    Image huebrKingImage;
    Image huebrQueenImage;
    //construtor>>

    public Huebr(Image image) {
        super(image);
    }
    //metodos>>
    
    ///HU3HU3HU3HU3 BRBRBRB

    public void createArmy(Army army, int sentido, PlayerPiece jogador) {
        /*
        // PlayerPiece pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image
              for(int j = 0; j < 8; j++) {
            army.addPiece(new Peon(new huebrPeon(), true, (int)(3.5 + sentido*2.5), j, huebrPeonImage));//peões
        }
        army.addPiece(new Bishop(new DefaultBishop(), true, (int)(3.5 + sentido*3.5), 2, huebrBishopImage));//bispos
        army.addPiece(new Bishop(new DefaultBishop(), true, (int)(3.5 + sentido*3.5), 5, huebrBishopImage));
        army.addPiece(new Horse(new DefaultHorse(),   true, (int)(3.5 + sentido*3.5), 1, huebrHorseImage));//cavalos
        army.addPiece(new Horse(new DefaultHorse(),   true, (int)(3.5 + sentido*3.5), 6, huebrHorseImage));
        army.addPiece(new Tower(new DefaultTower(),   true, (int)(3.5 + sentido*3.5), 0, huebrTowerImage));//torres
        army.addPiece(new Tower(new DefaultTower(),   true, (int)(3.5 + sentido*3.5), 7, huebrTowerImage));
        army.addPiece(new King(new DefaultKing(),     true, (int)(3.5 + sentido*3.5), 4, huebrKingImage));//rei
        army.addPiece(new Queen(new DefaultQueen(),   true, (int)(3.5 + sentido*3.5), 3, huebrQueenImage));//rainha
    */}
}

    

