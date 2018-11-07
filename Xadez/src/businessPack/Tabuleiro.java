
package businessPack;

import businessPack.Pecas.Queen;
import businessPack.Pecas.Peon;
import businessPack.Pecas.Tower;
import businessPack.Pecas.Horse;
import businessPack.Pecas.Bispo;
import businessPack.Pecas.King;


public class Tabuleiro{   
    Bloco[][] tab = new Bloco[8][8];

    public void InitTab8x8(Player p1, Player p2) {

        for(int i = 0; i < 8; i++) {
            tab[1][i] = new Bloco(p1.exercito.addPieceToArmy(new Peon("Peão", 2, 1)));
        }

        tab[0][0] = new Bloco(p1.exercito.addPieceToArmy(new Tower("Torre", 10, 2)));
        tab[0][7] = new Bloco(p1.exercito.addPieceToArmy(new Tower("Torre", 10, 2)));

        tab[0][1] = new Bloco(p1.exercito.addPieceToArmy(new Horse("Cavalo", 6, 3)));
        tab[0][6] = new Bloco(p1.exercito.addPieceToArmy(new Horse("Cavalo", 6, 3)));

        tab[0][2] = new Bloco(p1.exercito.addPieceToArmy(new Bispo("Bispo", 6, 3)));
        tab[0][5] = new Bloco(p1.exercito.addPieceToArmy(new Bispo("Bispo", 6, 3)));

        tab[0][3] = new Bloco(p1.exercito.addPieceToArmy(new King("Rei", 18, 3)));
        tab[0][4] = new Bloco(p1.exercito.addPieceToArmy(new Queen("Rainha", 8, 3)));

        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
                tab[i][j] = new Bloco();
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

