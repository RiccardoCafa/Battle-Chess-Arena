package xadez;

/**
 *
 * @author Lucas
 */
public class Vector2 {
    
    private float x;
    private float y;
    
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
     
    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
   
    public void setY(float y) {
        this.y = y;
    }
     
    public float getY() {
        return y;
    }
    
    public Vector2 sub(Vector2 vector1, Vector2 vector2) {
        try {
            Vector2 aux = new Vector2(vector1.getX() - vector2.getX(),
                                    vector1.getY() - vector2.getY());
            return aux;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Vector2 sum(Vector2 vector1, Vector2 vector2) {
        try {
            Vector2 aux = new Vector2(vector1.getX() + vector2.getX(),
                                    vector1.getY() + vector2.getY());
            return aux;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
