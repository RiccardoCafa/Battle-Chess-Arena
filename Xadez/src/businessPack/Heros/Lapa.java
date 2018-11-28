package businessPack.Heros;

import InterfaceView.GameCtrl;
import businessPack.Army;
import businessPack.Block;
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
import extras.Who;
import businessPack.TypeHero;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Lapa extends Hero {
    Image lapaTowerImage;
    Image lapaBishopImage;
    Image lapaPeonImage;
    Image lapaKingImage;
    Image lapaQueenImage;
    Image lapaHorseImage;
    
    GameCtrl game;
    Table tab;
    
    private int bigBig = 0;
    
    public Lapa() {
        tpHero = TypeHero.lapa;
        image = new Image(path + "lapa-01.png", widthImg, heightImg, false, false);
    }

    @Override
    public void createArmy(Army army, int sentido, Who jogador) {
        this.player = Players.getPlayer(jogador);
        for(int k = 1;k<7;k++){
            army.addPiece(new Peon(jogador, TypeHero.lapa, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Peon(jogador, TypeHero.lapa, 0, (int)(4 + sentido)));
        army.addPiece(new Peon(jogador, TypeHero.lapa, 7, (int)(4 + sentido)));
        army.addPiece(new Tower(jogador, TypeHero.lapa, 0, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.lapa, 1, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lapa, 2, (int)(3.5 + sentido*3.5)));
        army.addPiece(new King(jogador , TypeHero.lapa, 3, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Queen(jogador , TypeHero.lapa, 4, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lapa, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.lapa, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.lapa, 7, (int)(3.5 + sentido*3.5)));
    }
    //LapaGod

    @Override
    public void GameManager(Table tab) {
        System.out.println("Lapa é bom demais, n precisa de poderes");
    }
    
    public ArrayList<Block> getBombWays(Table tab, Player playing) {
        ArrayList<Block> tempList = new ArrayList<>();
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if(tab.getTable()[i][j].getBlockState(playing) == BlockState.Enemy) {
                    tempList.add(tab.getTable()[i][j]);
                }
            }
        }
        return tempList;
    }
    
    public void ExplodeBomb(Table tab, Vetor target, GameCtrl game) {
        //Substituir System.out.println por hit das peças
        if(this.game == null) this.game = game;
        if(this.tab == null) this.tab = tab;
        
        if(!tab.getBlock(target).isEmpty()) {
            if(tab.getBlock(target).hitPiece(4)) {
                game.removeImage(target);
                game.displayMessage("Lapa", "Exterminou o(a) " + tab.getBlock(target).getPiece().getPieceName() +
                            " adversária!");
            }
        }
        hitaDir(target, 1, 0); // -2
        hitaDir(target, -1, 0);
        hitaDir(target, 0, 1);
        hitaDir(target, 0, -1);
        hitaDir(target, 1, 1); //-1
        hitaDir(target, 1, -1);
        hitaDir(target, -1, 1);
        hitaDir(target, -1, -1);
        setBigBig(bigBig - 5);
    }
    
    public void hitaDir(Vetor target, int xDir, int yDir) {
        int xMax, yMax;
        //xMax = xDir == -1 ? 0 : Table.getM();
        //yMax = yDir == -1 ? 0 : Table.getN();
        if((target.getX()+xDir) > 0 && (target.getX()+xDir) < Table.getM() 
                && (target.getY() + yDir) < Table.getN() && (target.getY() + yDir) > 0) {
            Vetor newTarget = new Vetor(target.getX() + xDir, target.getY() + yDir);
            if(tab.getBlock(newTarget).isEmpty()) 
                    return;
            if(xDir == 0 || yDir == 0) {
                if(tab.getBlock(newTarget).hitPiece(2)) {
                    game.removeImage(newTarget);
                    game.displayMessage("Lapa", "Exterminou o(a) " + tab.getBlock(newTarget).getPiece().getPieceName() +
                            " adversária!");
                }
            } else {
                if(tab.getBlock(newTarget).hitPiece(1)) {
                    game.removeImage(newTarget);
                    game.displayMessage("Lapa", "Exterminou o(a) " + tab.getBlock(newTarget).getPiece().getPieceName() +
                            " adversário(a)!");
                }
            }
            
        }
    }

    /**
     * @return the bigBig
     */
    public int getBigBig() {
        return bigBig;
    }

    /**
     * @param bigBig the bigBig to set
     */
    public void setBigBig(int bigBig) {
        this.bigBig = bigBig;
    }

}
