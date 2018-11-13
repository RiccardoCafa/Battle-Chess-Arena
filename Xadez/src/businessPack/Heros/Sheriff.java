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
            army.addPiece(new Peon(jogador, TypeHero.sheriff, i, (int)(3.5 + sentido*2.5)));//peões
        }
        army.addPiece(new Bishop(jogador, TypeHero.sheriff, 2, (int)(3.5 + sentido*3.5)));//bispos
        army.addPiece(new Bishop(jogador, TypeHero.sheriff, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new  Horse(jogador, TypeHero.sheriff, 1, (int)(3.5 + sentido*3.5),  new SheriffHorse()));//cavalos
        army.addPiece(new  Horse(jogador, TypeHero.sheriff, 6, (int)(3.5 + sentido*3.5),  new SheriffHorse()));
        army.addPiece(new  Tower(jogador, TypeHero.sheriff, 0, (int)(3.5 + sentido*3.5)));//torres
        army.addPiece(new  Tower(jogador, TypeHero.sheriff, 7, (int)(3.5 + sentido*3.5)));
        army.addPiece(new   King(jogador, TypeHero.sheriff, 4, (int)(3.5 + sentido*3.5)));//rei
        army.addPiece(new  Queen(jogador, TypeHero.sheriff, 3, (int)(3.5 + sentido*3.5)));//rainha
    }
}