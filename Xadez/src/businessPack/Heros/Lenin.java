package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;

import businessPack.Pieces.Tower;
import businessPack.Pieces.Lenin.LeninTower;
import businessPack.TypeHero;

import javafx.scene.image.Image;

public class Lenin extends Hero {
    //atributos>>
    Image leninTowerImage;
    //construtor>>
    public Lenin(Image image) {
        super(image);
    }
    //metodos>>

    @Override
    public void createArmy(Army army, int sentido){
        //army.addPiece(new Tower(new LeninTower(), TypeHero.lenin, 0, 0, leninTowerImage));
    }
}