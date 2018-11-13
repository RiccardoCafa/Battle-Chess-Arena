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
import extras.PlayerPiece;
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
    public void createArmy(Army army, int sentido,PlayerPiece jogador){
        for(int i = 0; i < 8; i++) {
            //army.addPiece(new Peon(jogador, TypeHero.sheriff, i, 10, 1, (int)(3.5 + sentido*2.5), sheriffPeonImage));//peões
        }
//        army.addPiece(new Bishop(jogador , TypeHero.sheriff, 2, 10, 1, (int)(3.5 + sentido*3.5), sheriffBishopImage));//bispos
//        army.addPiece(new Bishop(jogador , TypeHero.sheriff, 5, 10, 1, (int)(3.5 + sentido*3.5), sheriffBishopImage));
//        army.addPiece(new  Horse(jogador , TypeHero.sheriff, 1, 10, 1, (int)(3.5 + sentido*3.5),  sheriffHorseImage));//cavalos
//        army.addPiece(new  Horse(jogador , TypeHero.sheriff, 6, 10, 1, (int)(3.5 + sentido*3.5),  sheriffHorseImage));
//        army.addPiece(new  Tower(jogador , TypeHero.sheriff, 0, 10, 1, (int)(3.5 + sentido*3.5),  sheriffTowerImage));//torres
//        army.addPiece(new  Tower(jogador , TypeHero.sheriff, 7, 10, 1, (int)(3.5 + sentido*3.5),  sheriffTowerImage));
//        army.addPiece(new   King(jogador , TypeHero.sheriff, 4, 10, 1, (int)(3.5 + sentido*3.5),   sheriffKingImage));//rei
//        army.addPiece(new  Queen(jogador , TypeHero.sheriff, 3, 10, 1, (int)(3.5 + sentido*3.5),  sheriffQueenImage));//rainha
    }
}