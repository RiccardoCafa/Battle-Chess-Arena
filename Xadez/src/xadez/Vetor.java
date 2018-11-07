package xadez;

/**
 *
 * @author Lucas
 */
public class Vetor {
    
    private int x;
    private int y;
    
    public Vetor(int x, int y) {
        this.x = x;
        this.y = y;
    }
     
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
   
    public void setY(int y) {
        this.y = y;
    }
     
    public int getY() {
        return y;
    }
    
    public Vetor sub(Vetor vector1, Vetor vector2) {
        try {
            Vetor aux = new Vetor(vector1.getX() - vector2.getX(),
                                  vector1.getY() - vector2.getY());
            return aux;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Vetor sum(Vetor vector1, Vetor vector2) {
        try {
            Vetor aux = new Vetor(vector1.getX() + vector2.getX(),
                                  vector1.getY() + vector2.getY());
            return aux;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
