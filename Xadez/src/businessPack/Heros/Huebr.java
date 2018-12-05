package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
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
    private boolean usePower;
    private int count = 0;
    
    boolean isHitted = false;
    //construtor>>

    public Huebr() {
        image = new Image(path + "animHueBR.gif", widthImg, heightImg, false, false);
        tpHero = TypeHero.huebr;
        
    }
    //metodos>>
    
    ///HU3HU3HU3HU3 BRBRBRB

    @Override
    public void createArmy(Army army, int sentido, Who jogador){
        this.player = Players.getPlayer(jogador);
        for(int k = 0;k<8;k++){
            army.addPiece(new Peon(jogador, TypeHero.huebr, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Tower(jogador, TypeHero.huebr, 0, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.huebr, 1, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.huebr, 2, (int)(3.5 + sentido*3.5)));
        army.addPiece(new King(jogador , TypeHero.huebr, 3, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Queen(jogador , TypeHero.huebr, 4, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.huebr, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.huebr, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.huebr, 7, (int)(3.5 + sentido*3.5)));
    }

    /**
     * @return the usePower
     */
    public boolean isUsePower() {
        if(count <= 2){
        return usePower;
        }
        return usePower = false;
}

    /**
     * @param usePower the usePower to set
     */
    public void setUsePower(boolean usePower) {
        this.usePower = usePower;
    }
    public int Contador(){
        return count;
    }

    @Override
    public void GameManager(Table tab) { // Roda a cada turno
        if(isUsePower()){
            Players.passTurn();
            count++;
            setUsePower(false);
        }
    }
}


    

