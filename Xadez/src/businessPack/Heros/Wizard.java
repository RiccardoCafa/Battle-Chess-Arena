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
    
    ImageView wizardWall;
    
    private int wallPos;
    private boolean wallSetted = false;
    private boolean canMoveWall = false;
    
    public Wizard() {

        image = new Image(path + "animWizard.gif", widthImg, heightImg, false, false);
        wizardWall = new ImageView(new Image("InterfaceView/imagens/barreira.png", 8*65, 50, false, false));
        wizardWall.setVisible(false);
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
    
    
    public ImageView getWallImage(){
        return wizardWall;
    }
    
    
    //metodo para colocar a barreira no tabuleiro
    public void setWall(Vetor grandLine){
        wallPos =  grandLine.getY();
//        getWallImage(wizardWall);
        wizardWall.setLayoutX(0);
        System.out.println("Setei para y = " + (15 + 65 * wallPos) );
        wizardWall.setLayoutY(15 + 65 * wallPos);
    }

    
    
    public boolean isWallSetted() {
        
        return wallSetted;
        
    }

    
    
    public void setWallSetted(boolean wallSetted) {
        wizardWall.setVisible(true);
        this.wallSetted = wallSetted;
        
    }

    
    
    public boolean getCanMove() {
        
        return canMoveWall;
        
    }

    
    
    public void setCanMove(boolean canMove) {
        
        this.canMoveWall = canMove;
    
    }

    
    
    //função que finalmente seta a barreira
    public void youShallNotPass(Block target){
    
        int burnBlock =  1; 
        System.out.println("O inimigo vai entrar viado");
        if(target.getBlockState(player) == BlockState.Enemy){
            System.out.println("Virei duas caras");
        //da dano na peça inimiga que estiver na barreira   
            target.hitPiece(burnBlock);    
        }else if(target.getBlockState(player) == BlockState.Friend){
           //cura a peça
            System.out.println("Curei o aliado");
           target.getPiece().healPiece(1);
        }
        
        
    }
    
    public int getWallVetorY(){
        
        return wallPos;
    }
    
    
    
    
    
    
}
