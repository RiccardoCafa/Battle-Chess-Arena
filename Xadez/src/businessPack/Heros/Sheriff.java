package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Default.DefaultBishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.Pieces.Sheriff.SheriffHorse;
import businessPack.Pieces.Sheriff.SheriffKing;
import businessPack.Pieces.Sheriff.SheriffPeon;
import businessPack.Pieces.Sheriff.SheriffQueen;
import businessPack.Pieces.Sheriff.SheriffTower;
import businessPack.Pieces.Tower;
import javafx.scene.image.Image;

public class Sheriff extends Hero {
    //atributos>>
    Image sheriffPeonImage;
    Image sheriffBishopImage;
    Image sheriffHorseImage;
    Image sheriffTowerImage;
    Image sheriffKingImage;
    Image sheriffQueenImage;
    //construtor>>
    public Sheriff(Image image) {
        super(image);
    }
    //metodos>>
    @Override
    public void createArmy(Army army, int sentido){
        for(int j = 0; j < 8; j++) {
            army.addPiece(new Peon(new SheriffPeon(), true, (int)(3.5 + sentido*2.5), j, sheriffPeonImage));//peões
        }
        army.addPiece(new Bishop(new DefaultBishop(), true, (int)(3.5 + sentido*3.5), 2, sheriffBishopImage));//bispos
        army.addPiece(new Bishop(new DefaultBishop(), true, (int)(3.5 + sentido*3.5), 5, sheriffBishopImage));
        army.addPiece(new Horse(new SheriffHorse(),   true, (int)(3.5 + sentido*3.5), 1, sheriffHorseImage));//cavalos
        army.addPiece(new Horse(new SheriffHorse(),   true, (int)(3.5 + sentido*3.5), 6, sheriffHorseImage));
        army.addPiece(new Tower(new SheriffTower(),   true, (int)(3.5 + sentido*3.5), 0, sheriffTowerImage));//torres
        army.addPiece(new Tower(new SheriffTower(),   true, (int)(3.5 + sentido*3.5), 7, sheriffTowerImage));
        army.addPiece(new King(new SheriffKing(),     true, (int)(3.5 + sentido*3.5), 4, sheriffKingImage));//rei
        army.addPiece(new Queen(new SheriffQueen(),   true, (int)(3.5 + sentido*3.5), 3, sheriffQueenImage));//rainha
    }
}