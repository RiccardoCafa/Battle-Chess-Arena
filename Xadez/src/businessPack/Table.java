
package businessPack;
import javafx.scene.image.Image;

public class Table{
    //atributos>>
    private Block[][] table;
    private int m;
    private int n;
    Image genericImage;//fiz apenas para não dar conflito nos argumentos que exigem imagens
    //construtor>>
    public Table(int m, int n, Player p1, Player p2) {
        this.m = m;
        this.n = n;
        table = new Block[m][n];//m = quantidade de linhas (relaciona-se com i); n = quantidade de colunas (relaciona-se com j)
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                table[i][j] = new Block(p1.getArmy().findPiece(i, j), i, j);
                if(p1.getArmy().findPiece(i, j) != null){
                    table[i][j] = new Block(p2.getArmy().findPiece(i, j), i, j);
                }
            }
        }
    }
    //getset>>
    public int getM(){
        return m;
    }
    public int getN(){
        return m;
    }
    
    public Block getBloco(int i, int j) {
        return table[i][j];
    }
}