package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Player;
import businessPack.Table;
import extras.Who;
import javafx.scene.image.Image;

public class Huebr extends Hero {

    Image huebrPeonImage;
    Image huebrBishopImage;
    Image huebrHorseImage;
    Image huebrTowerImage;
    Image huebrKingImage;
    Image huebrQueenImage;
    //construtor>>

    public Huebr() {
        image = new Image(path + "Huebr-01.png", widthImg, heightImg, false, false);
    }
    //metodos>>
    
    ///HU3HU3HU3HU3 BRBRBRB

    @Override
    public void createArmy(Army army, int sentido, Who jogador) {
        /*
        // Who pPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image
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

    @Override
    public void GameManager(Table tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


    

