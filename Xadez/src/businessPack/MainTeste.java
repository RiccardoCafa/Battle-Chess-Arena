package businessPack;

import businessPack.Heros.Lenin;
import businessPack.Heros.Sheriff;
import extras.Vetor;
import javafx.scene.image.Image;

public class MainTeste {
    public static void main(String[] args) {
        Image sheriffImage = null;
        Image leninImage = null;
        Player p1 = new Player(1, new Sheriff(sheriffImage));
        Player p2 = new Player(-1, new Lenin(leninImage));
        Table table = new Table(8, 8, p1, p2);
    }
}