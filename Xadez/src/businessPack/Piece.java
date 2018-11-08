
package businessPack;

import businessPack.Pieces.TypePiece;
import java.util.ArrayList;
import javafx.scene.image.Image;
import extras.Vetor;

public abstract class Piece {
    //atributos>>
    protected TypePiece tpPiece;
    protected TypeHero tpHero;
    protected Image image;
    protected int hp;
    protected boolean alive;
    protected int damage;
    protected Vetor vetor;
    protected ArrayList<Vetor> freeWay;
    protected ArrayList<Vetor> hitWay;
    //construtor>>
    protected Piece(TypePiece tpPiece, TypeHero tpHero, int hp, int damage, int x, int y, Image image){
        this.tpPiece = tpPiece;
        this.tpHero = tpHero;
        alive = true;
        this.hp = hp;
        this.damage = damage;
        vetor = new Vetor(x, y);
        this.image = image;
    }
    //metodos>>
    public abstract ArrayList<Vetor> checkMove(Table table);
    public void updateHitWay(Table table){
        hitWay.clear();
        for(Vetor vetor : freeWay){
            if(table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero() != tpHero){
                hitWay.add(vetor);
            }
        }
    }
    //getset>>
    public TypePiece getPiece(){
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
    public Vetor getVetor(){
        return vetor;
    }
    public TypeHero getTpHero(){
        return tpHero;
    }
}
