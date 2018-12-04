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
import businessPack.Pieces.Wizard.WizardBishop;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.BlockState;
import extras.Vetor;
import extras.Who;
import java.util.ArrayList;
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
        army.addPiece(new Queen(jogador , TypeHero.wizard, 4, (int)(3.5 + sentido*3.5)));        army.addPiece(new Bishop(jogador , TypeHero.wizard, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.wizard, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.wizard, 7, (int)(3.5 + sentido*3.5)));
                            
        army.addPiece(new Bishop(jogador, TypeHero.wizard, 5,(int)(3.5 + sentido*3.5)));

                            
    }

    @Override
    public void GameManager(Table tab){
       String a = "Nothing";
    } 
       
    //metodo para colocar a barreira no tabuleiro
    public ArrayList<Block> setWall(Table tab, Vetor grandLine){
        ArrayList<Block> wall = new ArrayList<>();
        //adicionar os blocos que estão atras
        for(int i = grandLine.getX(); i!=0; i--){
            wall.add(tab.getBlock(grandLine));
        }
        //adicionar os blocos que estão na frente
        for(int i = grandLine.getX(); i<=7; i = grandLine.getX() + 1 ){
        wall.add(tab.getBlock(grandLine));
        }
        
        
        return wall;
    }
    
    //método que procura os peões no tabuleiro
    public boolean searchPeons(Table tab, Vetor pos){
       return false;
    }

    public void wallCross(Table tab, Vetor target, ArrayList<Block> wall){
        int burnBlock =  1; 
    if(tab.getBlock(target).getBlockState(player) == BlockState.Enemy){
        //da dano na peça inimiga que estiver na barreira   
        tab.getBlock(target).hitPiece(burnBlock);
            
       }else if(tab.getBlock(target).getBlockState(player) == BlockState.Friend){
           //cura a peça
           tab.getBlock(target).hitPiece(-1);
        }
        
    }
    
 
    
    
    
    
    
    
}
