package businessPack.Heros;

import InterfaceView.GameManager;
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
    
    GameManager game;
    Table tab;
    
    private boolean jaFoiLapa = false;
    
    private int bigBig = 0;
    
    public static String description = "Este é o Professor God, um programador com poderes de hack o quanto suspeitos... Cuidado para não deixar ele acumular muitos big bigs" +
                " pode não ser muito vantajoso para você." + "\nEle tem apenas uma peça especial, mas não a subestime, ela foi programada por díscipulos dele!";
    public static String skills = "O seu assistente, pode ser chamado pelo Professor por um preço de 5 big bigs." + "\nApós ativado o poder, poderá escolher " + 
                "um inimigo para jogar uma bomba e atingir os alvos ao redor." + "\n-3HP para o alvo central\n-2HP para os alvos " +
                " na horizontal e vertical\n-1HP para os alvos nas diagonais";
    public static String movimentos = "A peça especial do Professor é a torre de duas cabeças!\n Ela é capaz de quebrar seu movimento na vertical e horizontal " +
                ", por exemplo, a torre tem 5 casas livres em sua frente, ela pode andar as 5 ou andar 4 e 1 para cada lado ou andar 3 e 2 "
                + "para cada lado, e assim por diante. \n Além disso, os peões em frente a Torre começam 2 casas pra frente!";
    
    public Lapa() {
        tpHero = TypeHero.lapa;
        image = new Image(path + "animLapa.gif", widthImg, heightImg, false, false);
        heroName = "Lapa";
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
        jaFoiLapa = false;
    }
    
    public ArrayList<Block> getBombWays(Table tab, Player playing) {
        ArrayList<Block> tempList = new ArrayList<>();
        if(jaFoiLapa) return tempList;
        for(int i = 0; i < Table.getM(); i++) {
            for(int j = 0; j < Table.getN(); j++) {
                if(tab.getTable()[i][j].getBlockState(playing) == BlockState.Enemy) {
                    tempList.add(tab.getTable()[i][j]);
                }
            }
        }
        return tempList;
    }
    
    public void ExplodeBomb(Table tab, Vetor target, GameManager game) {
        //Substituir System.out.println por hit das peças
        if(this.game == null) this.game = game;
        if(this.tab == null) this.tab = tab;
        
        if(!tab.getBlock(target).isEmpty()) {
            String pieceName = tab.getBlock(target).getPiece().getPieceName();
            if(tab.getBlock(target).hitPiece(4)) {
                game.displayMessage("O Professor", "Exterminou o(a) " + pieceName +
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
        jaFoiLapa = true;
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
            String pieceName = tab.getBlock(newTarget).getPiece().getPieceName();
            if(xDir == 0 || yDir == 0) {
                if(tab.getBlock(newTarget).hitPiece(2)) {
                    //game.removeImage(newTarget);
                    game.displayMessage("Professor", "Exterminou o(a) " + pieceName +
                            " adversária!");
                }
            } else {
                if(tab.getBlock(newTarget).hitPiece(1)) {
                    //game.removeImage(newTarget);
                    game.displayMessage("Professor", "Exterminou o(a) " + pieceName +
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
