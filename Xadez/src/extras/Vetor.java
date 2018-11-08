package extras;

/**
 *
 * @author Lucas
 */
public class Vetor {
    //atributos>>
    private int x;
    private int y;
    //construtor>>
    public Vetor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //metodos>>
    public static Vetor subtract(Vetor vetor1, Vetor vetor2) {
        try {
            Vetor aux = new Vetor(vetor1.getX() - vetor2.getX(),
                                  vetor1.getY() - vetor2.getY());
            return aux;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Vetor sum(Vetor vetor1, Vetor vetor2) {
        try {
            Vetor aux = new Vetor(vetor1.getX() + vetor2.getX(),
                                  vetor1.getY() + vetor2.getY());
            return aux;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
    //getset>>
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
