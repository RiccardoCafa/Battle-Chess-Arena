package businessPack;

import extras.Compass;
import extras.Vetor;
import javafx.scene.image.Image;

public class Table{
    //atributos>>
    private Block[][] table;
    private static int m;
    private static int n;
    Image genericImage;//fiz apenas para não dar conflito nos argumentos que exigem imagens
    //construtor>>
    public Table(int m, int n, Player p1, Player p2) {
        this.m = m;
        this.n = n;
        table = new Block[m][n];//m = quantidade de linhas (relaciona-se com i); n = quantidade de colunas (relaciona-se com j)
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                table[i][j] = new Block(null, i, j);
            }
        }
        /*for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                table[i][j] = new Block(p1.getArmy().findPiece(i, j), i, j);
                if(p1.getArmy().findPiece(i, j) != null){
                    table[i][j] = new Block(p2.getArmy().findPiece(i, j), i, j);
                }
            }
        }*/
    }
    //metodos>>
    public void clearTrend(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                table[m][n].getVetor().setTrend(Compass.C);
            }
        }
    }
    //getset>>    
    /**
     * 
     * @return the 'x' width of the table.
     */
    public static int getM(){
        return m;
    }
    
    /**
     *
     * @return the 'y' height of the table.
     */
    public static int getN(){
        return m;
    }
    
    public Block[][] getTable() {
        return table;
    }
    
    public Block getBlock(int x, int y){
        if(0 <= x && x < m && 0 <= y && y < n){
            return table[x][y];
        }else{
            return null;
        }
    }
    
    public Block getBlock(Vetor vetor){
        if(vetor.getX() >= 0 && vetor.getX() < m && vetor.getY() >= 0 && vetor.getY() < n){
            return table[vetor.getX()][vetor.getY()];
        }else{
            return null;
        }
    }
}