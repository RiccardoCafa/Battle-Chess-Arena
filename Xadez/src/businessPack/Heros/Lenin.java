package businessPack.Heros;

import InterfaceView.GameManager;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Lenin extends Hero {
    //atributos>>
    private ImageView persoImage;
    private int Estacao = 4;
    private boolean apareceae = true;
    private boolean mudanca2 = false;
    public static String description = "Grande Imperador do Imperio russo use poderoso exercito com seu mais temido general,mas existe um mau a espreita do seu governo";
    public static String skills = "General Inverno:" + "Cada turno agora é representado por estações do ano.Quando o inverno chega seu melhor general aparece e congela os peos inimigos e danifica a movimentacao do cavalo";
    public static String movimentos = "As peças especiais so aparecem quando o seu general chegar são a torre que ganha uma unidade de movimento para as diagonais,bispo que ganha uma unidade de movimento para as direcoes N,S,L,O,e o rei que anda uma unidade a mais em todas as direções";
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
            //army.addPiece(new Peon(jogador, TypeHero.lenin, k,(int)(3.5 + sentido*2.5)));
        }
        army.addPiece(new Peon(jogador, TypeHero.lenin, 1,(int)(3.5 + sentido*1.5)));
        army.addPiece(new Peon(jogador, TypeHero.lenin, 3,(int)(3.5 + sentido*1.5)));
        army.addPiece(new Peon(jogador, TypeHero.lenin, 5,(int)(3.5 + sentido*1.5)));
        army.addPiece(new Peon(jogador, TypeHero.lenin, 7,(int)(3.5 + sentido*1.5)));
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
        if(Estacao == 1){
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
        if(Estacao < 1){
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
           Estacao = 4;
        }
        leninSurgi();
    }
    public int getEstacao(){
        return Estacao;
    }
    public void leninSurgi(){
        if(Estacao == 1 && apareceae == true){
            apareceae = false;
            image = new Image(path + "transicao_lenin.gif", widthImg, heightImg, false, false);
            GameManager.gameCtrl.getPersoImage().setImage(image);
            mudanca2 = true;
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4500);
                        System.out.println("Acordei!");
                        image = new Image(path + "animLenin.gif", widthImg, heightImg, false, false);
                        if(Players.getActualPlayer().getHero() instanceof Lenin) {
                            GameManager.gameCtrl.getPersoImage().setImage(image);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Lenin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            new Thread(runner).start();
        }
        if(mudanca2 == true && Estacao == 4){
            image = new Image(path + "animLenin.gif", widthImg, heightImg, false, false);
        }
    }
}