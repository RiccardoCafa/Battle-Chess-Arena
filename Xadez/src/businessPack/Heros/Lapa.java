package businessPack.Heros;

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
    
    int bigBig = 0;
    
    public Lapa() {
        tpHero = TypeHero.lapa;
        image = new Image(path + "lapa-01.png", widthImg, heightImg, false, false);
    }

    @Override
    public void createArmy(Army army, int sentido, Who jogador) {
         for(int k = 0;k<8;k++){
            army.addPiece(new Peon(jogador, TypeHero.lapa, k,(int)(3.5 + sentido*2.5)));
        }
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
                if(tab.getTable()[i][j].getBlockState(playing) == BlockState.Empty ||
                    tab.getTable()[i][j].getBlockState(playing) == BlockState.Enemy) {
                    tempList.add(tab.getTable()[i][j]);
                }
            }
        }
        return tempList;
    }
    
    public void ExplodeBomb(Table tab, Vetor target) {
        //Substituir System.out.println por hit das peças
        if(!tab.getBlock(target).isEmpty()) {
            System.out.println("-4HP " + target.getX() + " " + target.getY());
        }
        hitaDir(target, 1, 0);
        hitaDir(target, -1, 0);
        hitaDir(target, 0, 1);
        hitaDir(target, 0, -1);
        hitaDir(target, 1, 1);
        hitaDir(target, 1, -1);
        hitaDir(target, -1, 1);
        hitaDir(target, -1, -1);
    }
    
    public void hitaDir(Vetor target, int xDir, int yDir) {
        int xMax, yMax;
        xMax = xDir == -1 ? 0 : Table.getM();
        yMax = yDir == -1 ? 0 : Table.getN();
        if((target.getX()+xDir) < xMax && (target.getY() + yDir) < yMax) {
            if(xDir == 0 ^ yDir == 0) {
                System.out.println("-2HP " + (target.getX()+xDir) + " " + (target.getY() + yDir));
            } else {
                System.out.println("-1HP " + (target.getX()+xDir) + " " + (target.getY() + yDir));
            }
            
        }
    }

}
