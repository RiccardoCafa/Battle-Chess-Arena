package businessPack;

import businessPack.Heros.Lapa;
import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import businessPack.Heros.Wizard;
import businessPack.Pieces.Bishop;
import businessPack.Pieces.Lapa.LapaTower;
import businessPack.Pieces.Tower;
import extras.PlayerPiece;
import static extras.PlayerPiece.Player1;
import static extras.PlayerPiece.Player2;
import javafx.scene.image.Image;

public class MainTeste {
    public static void main(String[] args) {
        //Pegando imagens
        Image sheriffImage = null;
        Image leninImage = null;
        //Criando os players
        Player p1 = new Player(1, new Sheriff(sheriffImage), 1,Player1);
        Player p2 = new Player(-1, new Lenin(leninImage), 2,Player2);
        //Cirando os personagens dos players
        Lapa lapa = new Lapa(null);
        Wizard wizard = new Wizard(null);
        //Criando o tabuleiro
        Table table = new Table(8, 8, p1, p2);
        Tower t = new Tower(PlayerPiece.Player1, TypeHero.lapa, 5, 5, 3, 4, null, new LapaTower(p1));
        table.getTable()[3][4] = new Block(t, 3, 4);
        Bishop b = new Bishop(PlayerPiece.Player2, TypeHero.wizard, 5, 5, 3, 7, null);
        table.getTable()[3][2] = new Block(b, 3, 8);
        t.checkMove(table);
        
    }
}