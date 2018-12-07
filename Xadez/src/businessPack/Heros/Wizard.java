package businessPack.Heros;


import InterfaceView.GameManager;
import businessPack.Army;
import businessPack.Block;
import businessPack.Hero;
import businessPack.Piece;
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
import businessPack.TypePiece;
import extras.BlockState;
import extras.Vetor;
import extras.Who;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wizard extends Hero {
    
    // atributos
    
    ImageView wizardWall[] = new ImageView[8];
    
    private int wallPos;
    private boolean wallSetted = false;
    private boolean canMoveWall = false;
    
    
    
    public static String description = "Contemplem o Mago Supremo Fandalg, senhor supremo das estratégias, este temivel"
            + " ser participa do xadrez com grande inteligencia e perspicácia, são poucos os oponentes que "
            + "o desafiaram e sobreviveram para contar a história, porém, todos eles concordam: se o Mago quiser, ninguem vai passar";
    public static String skill= " A Barreira Mágica do Mago, queima inimigos e os transforma em cinzas, ao mesmo tempo que cura aliados, lhes restaurando o vigor"
            + " controlando o campo com supremacia e força";
    public static String movimentos= "O Mago tem o auxilio dos Bispos Mágicos, seres de incríveis magia, capazes de quebrar seus movimentos na diagonal"
            + "se tornando temíveis máquinas de destruição em massa do tabuleiro";
    
    
    public Wizard() {
        heroName = "Wizard";
        image = new Image(path + "animWizard.gif", widthImg, heightImg, false, false);
        for(int i = 0; i < 8; i ++ ) {
            wizardWall[i] = new ImageView(new Image("InterfaceView/imagens/barreira.png", 65, 50, false, false));
            wizardWall[i].setVisible(false);
        }
        
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
        army.addPiece(new Queen(jogador , TypeHero.wizard, 4, (int)(3.5 + sentido*3.5)));        army.addPiece(new Bishop(jogador , TypeHero.wizard, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.wizard, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.wizard, 7, (int)(3.5 + sentido*3.5)));
//                            
        army.addPiece(new Bishop(jogador, TypeHero.wizard, 5,(int)(3.5 + sentido*3.5)));

                            
    }

    @Override
    public void GameManager(Table tab){
       String a = "Nothing";
    }
    
    
    public ArrayList<Block> getWallWays(Table tab) {
        ArrayList<Block> tempList = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            tempList.add(tab.getBlock(0, i));
        }
        return tempList;
    }
    
    
    public ImageView getWallImage(int index){
        return wizardWall[index];
    }
    
    
    //metodo para colocar a barreira no tabuleiro
    public void setWall(Vetor grandLine){
        wallPos =  grandLine.getY();
//        getWallImage(wizardWall);
        for(int i = 0; i < 8; i ++ ) {
            wizardWall[i].setLayoutX(0);
//        System.out.println("Setei para y = " + (15 + 65 * wallPos) );
            wizardWall[i].setLayoutY(15 + 65 * wallPos);
            wizardWall[i].setLayoutX(i * 65);
        }
        
    }

    
    
    public boolean isWallSetted() {
        
        return wallSetted;
        
    }

    
    
    public void setWallSetted(boolean wallSetted) {
        for(int i = 0; i < 8; i ++ ) {
            wizardWall[i].setVisible(true);
        }
        this.wallSetted = wallSetted;
        
    }

    
    
    public boolean getCanMove() {
        
        return canMoveWall;
        
    }

    
    
    public void setCanMove(boolean canMove) {
        
        this.canMoveWall = canMove;
    
    }
    
    public void wallToBack(int i) {
        wizardWall[i].toBack();
    }
    
    public void wallToFront(int i) {
        wizardWall[i].toFront();
    }
    
    //função que finalmente seta a barreira
    public void youShallNotPass(Block sourceBlock, Block destinyBlock){
    
        if((sourceBlock.getVetor().getY() <= getWallVetorY() &&
            destinyBlock.getVetor().getY() > getWallVetorY()) ||
            sourceBlock.getVetor().getY() > getWallVetorY() &&
            destinyBlock.getVetor().getY() <= getWallVetorY()){
            int burnBlock =  1; 
            if(destinyBlock.getBlockState(player) == BlockState.Enemy){
                destinyBlock.hitPiece(burnBlock);    
            }else if(destinyBlock.getBlockState(player) == BlockState.Friend){
               destinyBlock.getPiece().healPiece(1);
            }
        }
    }
    
    public int getWallVetorY(){
        
        return wallPos;
    }
}
