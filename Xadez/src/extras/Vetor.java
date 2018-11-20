package extras;

import businessPack.Table;

public class Vetor {
    //atributos>>
    private int x;
    private int y;
    private int[] trend;//fluxo do vetor, registrando de onde veio
    //construtor>>
    public Vetor(int x, int y) {
        trend = new int[2];
        this.x = x;
        this.y = y;
        trend[0] = 0;
        trend[1] = 0;
    }
    public Vetor(Vetor vetor) {
        trend = new int[2];
        this.x = vetor.getX();
        this.y = vetor.getY();
        trend[0] = 0;
        trend[1] = 0;
    }
    public Vetor(int x, int y, Vetor versor) {
        trend = new int[2];
        this.x = x;
        this.y = y;
        if(versor.getX() >= -1 && versor.getX() <= 1 && versor.getY() >= -1 && versor.getX() <= 1){
            trend[0] = versor.getX();
            trend[1] = versor.getY();
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
    public static Vetor sum(int x1, int y1, int x2, int y2) {
        return new Vetor(x1 + x2, y1 + y2);
    }
    public Vetor next(){
        return Vetor.sum(trend[0], trend[1], x, y);
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
    public static Vetor getTrend(int x){
        switch(x%9){
            case  1: return new Vetor( 0, -1);
            case  2: return new Vetor( 1, -1);
            case  3: return new Vetor( 1,  0);
            case  4: return new Vetor( 1,  1);//  8 1 2
            case  5: return new Vetor( 0,  1);// 7  0  3
            case  6: return new Vetor(-1,  1);//  6 5 4
            case  7: return new Vetor( 1,  0);
            case  8: return new Vetor(-1, -1);
            default: return new Vetor( 0,  0);
        }
    }
    public void setTrend(int x){
        switch(x%9){
            case  1: trend[0] =  0; trend[1] = -1;
            case  2: trend[0] =  1; trend[1] = -1;
            case  3: trend[0] =  1; trend[1] =  0;
            case  4: trend[0] =  1; trend[1] =  1;//  8 1 2
            case  5: trend[0] =  0; trend[1] =  1;// 7  0  3
            case  6: trend[0] = -1; trend[1] =  1;//  6 5 4
            case  7: trend[0] =  1; trend[1] =  0;
            case  8: trend[0] = -1; trend[1] = -1;
            default: trend[0] =  0; trend[1] =  0;
        }
    }
    public void setTrend(Vetor versor){
        trend[0] =  versor.getX();
        trend[1] = versor.getY();
    }
}