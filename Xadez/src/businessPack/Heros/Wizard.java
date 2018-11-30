package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.Pieces.Tower;
import businessPack.Pieces.Wizard.WizardBishop;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;
import javafx.scene.image.Image;

public class Wizard extends Hero {
    
    // atributos
    Image wizardBishop;
    Image wizardPeon;
    Image wizardKing;
    Image wizardQueen;
    Image wizardHorse;
    Image wizardTower;
    
    public Wizard() {
        image = new Image(path + "omago-01.png", widthImg, heightImg, false, false);
        tpHero = TypeHero.wizard;
    }
    
    // comtemplem o mago

    @Override
    public void createArmy(Army army, int sentido, Who jogador) {
        this.player = Players.getPlayer(jogador);
        for( int k = 0 ; k < 8; k++ ){
            army.addPiece(new Peon(jogador, TypeHero.wizard, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Tower(jogador, TypeHero.wizard, 0, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.wizard, 1, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.wizard, 2, (int)(3.5 + sentido*3.5)));
        army.addPiece(new King(jogador , TypeHero.wizard, 3, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Queen(jogador , TypeHero.wizard, 4, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.wizard, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.wizard, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.wizard, 7, (int)(3.5 + sentido*3.5)));
                            
        army.addPiece(new Bishop(jogador, TypeHero.wizard, 4,(int)(3.5 + sentido*2.5)));

                            
    }

    @Override
    public void GameManager(Table tab) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
