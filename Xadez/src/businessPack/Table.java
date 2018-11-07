
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
            table[1][j] = new Block(p1.army.addPiece(new Peon(true, 1, j, genericImage)), 1, j);
        }
        table[0][0] = new Block(p1.army.addPiece(new Tower(true, 0, 0, genericImage)), 0, 0);
        table[0][7] = new Block(p1.army.addPiece(new Tower(true, 0, 7, genericImage)), 0, 7);

        table[0][1] = new Block(p1.army.addPiece(new Horse(true, 0, 1, genericImage)), 0, 1);
        table[0][6] = new Block(p1.army.addPiece(new Horse(true, 0, 6, genericImage)), 0, 6);

        table[0][2] = new Block(p1.army.addPiece(new Bishop(true, 0, 2, genericImage)), 0, 2);
        table[0][5] = new Block(p1.army.addPiece(new Bishop(true, 0, 5, genericImage)), 0, 5);

        table[0][3] = new Block(p1.army.addPiece(new King(true, 0, 3, genericImage)), 0, 3);
        table[0][4] = new Block(p1.army.addPiece(new Bishop(true, 0, 2, genericImage)), 0, 4);

        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
                table[i][j] = new Block();
            }
        }

        for(int i = 0; i < 8; i++) {
            tab[7][i] = new Bloco(p2.exercito.addPieceToArmy(new Peon("Peão", 2, 1)));
        }

        tab[0][0] = new Bloco(p2.exercito.addPieceToArmy(new Tower("Torre", 10, 2)));
        tab[0][7] = new Bloco(p2.exercito.addPieceToArmy(new Tower("Torre",10, 2)));

        tab[0][1] = new Bloco(p2.exercito.addPieceToArmy(new Horse("Cavalo", 6, 3)));
        tab[0][6] = new Bloco(p2.exercito.addPieceToArmy(new Horse("Cavalo", 6, 3)));

        tab[0][2] = new Bloco(p2.exercito.addPieceToArmy(new Bispo("Bispo", 6, 3)));
        tab[0][5] = new Bloco(p2.exercito.addPieceToArmy(new Bispo("Bispo", 6, 3)));

        tab[0][3] = new Bloco(p2.exercito.addPieceToArmy(new King("Rei", 18, 3)));
        tab[0][4] = new Bloco(p2.exercito.addPieceToArmy(new Queen("Rainha", 8, 3)));
    }
     
}

