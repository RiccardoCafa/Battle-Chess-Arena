
package businessPack;

import businessPack.Pecas.typePiece;
import javafx.scene.image.Image;
import xadez.Vetor;

public abstract class Piece {
    //atributos>>
    private typePiece tpPiece;
    public Image image;
    public int hp;
    public boolean alive;
    public int damage;
    public Vetor vetor;
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
