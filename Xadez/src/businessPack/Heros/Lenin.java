package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Piece;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.EnemyLenin.EnemyHorseLenin;
import businessPack.Pieces.EnemyLenin.EnemyPeonLenin;
import businessPack.Pieces.Horse;
import businessPack.Pieces.King;
import businessPack.Pieces.Lenin.LeninBishop;
import businessPack.Pieces.Lenin.LeninKing;
import businessPack.Pieces.Lenin.LeninTower;
import businessPack.Pieces.Tower;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Queen;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import businessPack.TypePiece;
import extras.Who;
import javafx.scene.image.Image;

public class Lenin extends Hero {
    //atributos>>
    Image leninTowerImage;
    Image LeninBishopImage;
    Image LeninPeonImage;
    Image LeninKingImage;
    Image LeninQueenImage;
    Image LeninHorseImage;
    private int Estacao = 4;
    //construtor>>
    public Lenin() {
        image = new Image(path + "lenin-01.png", widthImg, heightImg, false, false);
        tpHero = TypeHero.lenin;
    }

    //metodos>>
    @Override
    public void createArmy(Army army, int sentido, Who jogador){
        this.player = Players.getPlayer(jogador);
        for(int k = 0;k<8;k++){
            army.addPiece(new Peon(jogador, TypeHero.lenin, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Tower(jogador, TypeHero.lenin, 0, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.lenin, 1, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lenin, 2, (int)(3.5 + sentido*3.5)));
        army.addPiece(new King(jogador , TypeHero.lenin, 3, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Queen(jogador , TypeHero.lenin, 4, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Bishop(jogador , TypeHero.lenin, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Horse(jogador , TypeHero.lenin, 6, (int)(3.5 + sentido*3.5)));
        army.addPiece(new Tower(jogador , TypeHero.lenin, 7, (int)(3.5 + sentido*3.5)));
    }

    @Override
    public void GameManager(Table tab) {
        Player myPlayer = Players.getActualPlayer();
        Player enemyPlayer = Players.getPlayer(myPlayer.getWho() == Who.player1 ? Who.player2 : Who.player1);
        System.err.println("Estacao"+Estacao);
        Estacao--;
        if(Estacao == 0){
           for(Piece b : myPlayer.getArmy().getArmyList()){
               if(b.getPiece() == TypePiece.bishop){
                   LeninBishop LB = new LeninBishop(myPlayer);
                   b.setStrategy(LB);
                   //System.out.println("Encontrei um bispo");
               }
               if(b.getPiece() == TypePiece.king){
                   LeninKing LK = new LeninKing(myPlayer);
                   b.setStrategy(LK);
               }
               if(b.getPiece() == TypePiece.tower){
                   LeninTower LT = new LeninTower(myPlayer);
                   b.setStrategy(LT);
               }
           }
           for(Piece c : enemyPlayer.getArmy().getArmyList()){
               if(c.getPiece() == TypePiece.horse){
                   EnemyHorseLenin HL = new EnemyHorseLenin(enemyPlayer);
                   c.setStrategy(HL);
               }
               if(c.getPiece() == TypePiece.peon){
                    EnemyPeonLenin PL = new EnemyPeonLenin(enemyPlayer);
                    c.setStrategy(PL);
               }
           }
        }
        if(Estacao < 0){
            //System.out.println("Estacao virou");
            for(Piece b : myPlayer.getArmy().getArmyList()){
               if(b.getPiece() == TypePiece.bishop){
                   b.setStrategy(b.getHeroStrategy());
                   //System.out.println("Encontrei um bispo para default");
               }
               if(b.getPiece() == TypePiece.king){
                   b.setStrategy(b.getHeroStrategy());
               }
               if(b.getPiece() == TypePiece.tower){
                   b.setStrategy(b.getHeroStrategy());
               }
           }
           for(Piece b : enemyPlayer.getArmy().getArmyList()){
               if(b.getPiece() == TypePiece.horse){
                   b.setStrategy(b.getHeroStrategy());
               }
               if(b.getPiece() == TypePiece.peon){
                    b.setStrategy(b.getHeroStrategy());
               }
           }
           Estacao = 3;
        }
    }
}