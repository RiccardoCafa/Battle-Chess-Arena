package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Default.DefaultHorse;
import businessPack.Pieces.Default.DefaultPeon;
import businessPack.Pieces.Default.DefaultQueen;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Lenin.LeninBishop;
import businessPack.Pieces.Lenin.LeninKing;
import businessPack.Pieces.Tower;
import businessPack.Pieces.Lenin.LeninTower;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.TypeHero;
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
    public void createArmy(Army army, int sentido){
        for(int k = 0;k<8;k++){
            army.addPiece(new Peon(new DefaultPeon(), TypeHero.lenin, k, (int)(3.5 + sentido*2.5), LeninPeonImage)); //peões
        }
        army.addPiece(new Tower(new LeninTower(), TypeHero.lenin, 0, (int)(3.5 + sentido*2.5), leninTowerImage));
        army.addPiece(new Horse(new DefaultHorse(), TypeHero.lenin, 1, (int)(3.5 + sentido*2.5), LeninQueenImage));
        army.addPiece(new Bishop(new LeninBishop(), TypeHero.lenin, 2, (int)(3.5 + sentido*2.5), LeninBishopImage));
        army.addPiece(new King(new LeninKing(), TypeHero.lenin, 3, (int)(3.5 + sentido*2.5), LeninKingImage));
        army.addPiece(new Queen(new DefaultQueen(), TypeHero.lenin, 4, (int)(3.5 + sentido*2.5), LeninQueenImage));
        army.addPiece(new Bishop(new LeninBishop(), TypeHero.lenin, 5, (int)(3.5 + sentido*2.5), LeninBishopImage));
        army.addPiece(new Horse(new DefaultHorse(), TypeHero.lenin, 6, (int)(3.5 + sentido*2.5), LeninQueenImage));
        army.addPiece(new Tower(new LeninTower(), TypeHero.lenin, 7, (int)(3.5 + sentido*2.5), leninTowerImage));
    }
}