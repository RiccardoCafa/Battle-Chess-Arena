package extras;

import businessPack.Table;

public class Vetor {
    //atributos>>
    private int x;
    private int y;
    private Vetor trend;//fluxo do vetor, registrando de onde veio
    //construtor>>

    /**
     *
     * @param x
     * @param y
     */
    public Vetor(int x, int y) {
        this.x = x;
        this.y = y;
        trend = new Vetor(0, 0);//caso não haja necessidade de salvar a posição anterior, o trend será o centro "C"
    }
    
    /**
     *
     * @param vetor
     */
    public Vetor(Vetor vetor) {
        this.x = vetor.getX();
        this.y = vetor.getY();
        trend = new Vetor(0, 0);//caso não haja necessidade de salvar a posição anterior, o trend será o centro "C"
    }
    public Vetor(int x, int y, Vetor versor) {
        this.x = x;
        this.y = y;
        if(versor.getX() >= -1 && versor.getX() <= 1 && versor.getY() >= -1 && versor.getX() <= 1){
            trend = versor;
        } 
    }
    //metodos>>
    public static Vetor subtract(Vetor vetor1, Vetor vetor2) {//subtrai dois vetores
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
    public static Vetor sum(Vetor vetor1, Vetor vetor2) {//soma dois vetores
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
    public Vetor next(){
        return Vetor.sum(trend, x, y);
    }
    public void setTrend(int x){
        switch(x){
            case  1: trend = new Vetor( 0, -1);
            case  2: trend = new Vetor( 1, -1);
            case  3: trend = new Vetor( 1,  0);
            case  4: trend = new Vetor( 1,  1);// 8 1 2
            case  5: trend = new Vetor( 0,  1);// 7   3
            case  6: trend = new Vetor(-1,  1);// 6 5 4
            case  7: trend = new Vetor( 1,  0);
            case  8: trend = new Vetor(-1, -1);
            default: trend = new Vetor( 0,  0);
        }
    }
}