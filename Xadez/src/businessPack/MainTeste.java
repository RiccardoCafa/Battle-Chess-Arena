package businessPack;

import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Tower;
import extras.Who;
import javafx.scene.image.Image;

public class MainTeste {
    public static void main(String[] args) {
        //Pegando imagens
        Image sheriffImage = null;
        Image leninImage = null;
        //Criando os players
        Player p1 = new Player(1, new Sheriff(sheriffImage), 1);
        Player p2 = new Player(-1, new Lenin(leninImage), 2);
        //Cirando os personagens dos players
        Lapa lapa = new Lapa(null);
        Wizard wizard = new Wizard(null);
        //Criando o tabuleiro
        Table table = new Table(8, 8, p1, p2);
        
        Tower t = new Tower(Who.player1, TypeHero.lapa, 2, 3, new LapaTower(p1));
        table.getTable()[2][3] = new Block(t, 2, 3);
        Bishop b = new Bishop(Who.player2, TypeHero.wizard, 2, 1);
        table.getTable()[2][1] = new Block(b, 2, 1);
        Bishop b2 = new Bishop(Who.player2, TypeHero.wizard, 6, 3);
        table.getTable()[6][3] = new Block(b2, 6, 3);
        Bishop b1 = new Bishop(Who.player1, TypeHero.lapa, 0, 3);
        table.getTable()[0][3] = new Block(b1, 0, 3);
        t.checkMove(table);
        
    }
}