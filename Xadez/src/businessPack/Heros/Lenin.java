package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Tower;
import businessPack.Pieces.Lenin.LeninTower;
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
    public void createArmy(Army army){
        army.addPiece(new Tower(new LeninTower(), true, 0, 0, leninTowerImage));
    }
}