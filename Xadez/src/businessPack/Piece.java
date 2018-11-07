
package businessPack;

import businessPack.Pecas.typePiece;
import java.util.ArrayList;
import javafx.scene.image.Image;
import xadez.Vetor;

public abstract class Piece {
    //atributos>>
    protected typePiece tpPiece;
    protected Image image;
    protected int hp;
    protected boolean alive;
    protected int damage;
    protected Vetor vetor;
    protected ArrayList<Vetor> freeWay;
    protected ArrayList<Vetor> hitWay;
    //construtor>>
    public Piece(typePiece tpPiece, boolean alive, int hp, int damage, int x, int y, Image image){
        this.tpPiece = tpPiece;
        this.alive = alive;
        this.hp = hp;
        this.damage = damage;
        vetor = new Vetor(x, y);
        this.image = image;
    }
    //metodos>>
    public abstract void checkMove(Table table);
    //getset>>
    public typePiece getPiece(){
        return tpPiece;
    }
    public int getHP(){
        return hp;
    }
    public void setHP(int hp){
        this.hp = hp;
    }
    public boolean getLife(){
        return alive;
    }
    public void setLife(boolean alive){
        this.alive = alive;
    }
    public int getDamage(){
        return damage;
    }
}
