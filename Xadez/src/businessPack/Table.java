
package businessPack;
import businessPack.Pecas.Queen;
import businessPack.Pecas.Peon;
import businessPack.Pecas.Tower;
import businessPack.Pecas.Horse;
import businessPack.Pecas.Bishop;
import businessPack.Pecas.King;
import javafx.scene.image.Image;

public class Table{
    //atributos>>
    private Block[][] table;
    Image genericImage;//fiz apenas para não dar conflito nos argumentos que exigem imagens
    //construtor>>
    public Table(int m, int n, Player p1, Player p2) {
        table = new Block[m][n];//m = quantidade de linhas (relaciona-se com i); n = quantidade de colunas (relaciona-se com j)
        for(int j = 0; j < n; j++) {
            table[1][j] = new Block(p1.getArmy().addPiece(new Peon(true, 1, j, genericImage)), 1, j);//peões
        }
        table[0][0] = new Block(p1.getArmy().addPiece(new Tower(true, 0, 0, genericImage)), 0, 0);//torres
        table[0][7] = new Block(p1.getArmy().addPiece(new Tower(true, 0, 7, genericImage)), 0, 7);
        table[0][1] = new Block(p1.getArmy().addPiece(new Horse(true, 0, 1, genericImage)), 0, 1);//cavalos
        table[0][6] = new Block(p1.getArmy().addPiece(new Horse(true, 0, 6, genericImage)), 0, 6);
        table[0][2] = new Block(p1.getArmy().addPiece(new Bishop(true, 0, 2, genericImage)), 0, 2);//bispos
        table[0][5] = new Block(p1.getArmy().addPiece(new Bishop(true, 0, 5, genericImage)), 0, 5);
        table[0][3] = new Block(p1.getArmy().addPiece(new King(true, 0, 3, genericImage)), 0, 3);//rei
        table[0][4] = new Block(p1.getArmy().addPiece(new Queen(true, 0, 4, genericImage)), 0, 4);//rainha
        for(int i = 0; i < 8; i++) {
            for(int j = 2; j < 6; j++) {
                table[i][j] = new Block(null, i, j);
            }
        }
        for(int j = 0; j < n; j++) {
            table[7][j] = new Block(p2.getArmy().addPiece(new Peon(true, 1, j, genericImage)), 1, j);//peões
        }
        table[7][0] = new Block(p2.getArmy().addPiece(new Tower(true, 7, 0, genericImage)), 7, 0);//torres
        table[7][7] = new Block(p2.getArmy().addPiece(new Tower(true, 7, 7, genericImage)), 7, 7);
        table[7][1] = new Block(p2.getArmy().addPiece(new Horse(true, 7, 1, genericImage)), 7, 1);//cavalos
        table[7][6] = new Block(p2.getArmy().addPiece(new Horse(true, 7, 6, genericImage)), 7, 6);
        table[7][2] = new Block(p2.getArmy().addPiece(new Bishop(true, 7, 2, genericImage)), 7, 2);//bispos
        table[7][5] = new Block(p2.getArmy().addPiece(new Bishop(true, 7, 5, genericImage)), 7, 5);
        table[7][3] = new Block(p2.getArmy().addPiece(new King(true, 7, 3, genericImage)), 7, 3);//rei
        table[7][4] = new Block(p2.getArmy().addPiece(new Queen(true, 7, 4, genericImage)), 7, 4);//rainha
    }
}