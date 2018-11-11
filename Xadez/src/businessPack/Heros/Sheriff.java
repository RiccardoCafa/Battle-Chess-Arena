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
import businessPack.TypeHero;
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
        for(int i = 0; i < 8; i++) {
            //army.addPiece(new Peon(new SheriffPeon(), TypeHero.sheriff, i, (int)(3.5 + sentido*2.5), sheriffPeonImage));//peões
        }
        //army.addPiece(new Bishop(new DefaultBishop(), TypeHero.sheriff, 2, (int)(3.5 + sentido*3.5), sheriffBishopImage));//bispos
        //army.addPiece(new Bishop(new DefaultBishop(), TypeHero.sheriff, 5, (int)(3.5 + sentido*3.5), sheriffBishopImage));
        //army.addPiece(new  Horse(new  SheriffHorse(), TypeHero.sheriff, 1, (int)(3.5 + sentido*3.5),  sheriffHorseImage));//cavalos
        //army.addPiece(new  Horse(new  SheriffHorse(), TypeHero.sheriff, 6, (int)(3.5 + sentido*3.5),  sheriffHorseImage));
        //army.addPiece(new  Tower(new  SheriffTower(), TypeHero.sheriff, 0, (int)(3.5 + sentido*3.5),  sheriffTowerImage));//torres
        //army.addPiece(new  Tower(new  SheriffTower(), TypeHero.sheriff, 7, (int)(3.5 + sentido*3.5),  sheriffTowerImage));
        //army.addPiece(new   King(new   SheriffKing(), TypeHero.sheriff, 4, (int)(3.5 + sentido*3.5),   sheriffKingImage));//rei
        //army.addPiece(new  Queen(new  SheriffQueen(), TypeHero.sheriff, 3, (int)(3.5 + sentido*3.5),  sheriffQueenImage));//rainha
    }
}