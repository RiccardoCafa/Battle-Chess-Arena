package extras;

import businessPack.Table;

public class Vetor {
    //atributos>>
    private int x;
    private int y;
    private Compass trend;
    //construtor>>
    public Vetor(int x, int y) {
        this.x = x;
        this.y = y;
        trend = Compass.C;
    }
    public Vetor(int x, int y, Compass trend) {
        this.x = x;
        this.y = y;
        this.trend = trend;
    }
    //metodos>>
    public static Vetor subtract(Vetor vetor1, Vetor vetor2) {
        return new Vetor(vetor1.getX() - vetor2.getX(),
                         vetor1.getY() - vetor2.getY());
    }
    public static Vetor subtract(Vetor vetor1, int x2, int y2) {
        return new Vetor(vetor1.getX() - x2,
                         vetor1.getY() - y2);
    }
    public static Vetor subtract(int x1, int y1, Vetor vetor2) {
        return new Vetor(x1 - vetor2.getX(),
                         y1 - vetor2.getY());
    }
    public static Vetor sum(Vetor vetor1, Vetor vetor2) {
        return new Vetor(vetor1.getX() + vetor2.getX(),
                         vetor1.getY() + vetor2.getY());
    }
    public static Vetor sum(Vetor vetor1, int x2, int y2) {
        return new Vetor(vetor1.getX() + x2,
                         vetor1.getY() + y2);
    }
    public static Vetor sum(int x1, int y1, Vetor vetor2) {
        return new Vetor(x1 + vetor2.getX(),
                         y1 + vetor2.getY());
    }
    //getset>>
    public int getX() {
        return x;
    }
    public void setX(int x) {
        if(x >= 0 && x <= Table.getM()){
            this.x = x;
        }
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        if(y >= 0 && y <= Table.getN()){
            this.y = y;
        }
    }
    public Compass getTrend(){
        return trend;
    }
    public void setTrend(Compass trend){
        this.trend = trend;
    }
}