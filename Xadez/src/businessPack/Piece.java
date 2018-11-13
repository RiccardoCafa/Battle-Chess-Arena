package businessPack;

import extras.PlayerPiece;
import java.util.ArrayList;
import javafx.scene.image.Image;
import extras.Vetor;
import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView {

    //atributos>>
    protected TypePiece tpPiece;
    protected TypeHero tpHero;
    protected PlayerPiece player;
    //protected Image image;
    protected int hp;
    protected int damage = 1;
    protected boolean alive;
    protected boolean empty;
    protected Vetor vetor;
    protected ArrayList<Block> freeWay;
    protected ArrayList<Block> hitWay;
    //construtor>>
    protected Piece(PlayerPiece pPiece, TypeHero tpHero, int x, int y){
        this.tpHero = tpHero;
        this.player = pPiece;
        alive = true;
        vetor = new Vetor(x, y);
    }
    protected Piece(TypePiece tpPiece, TypeHero tpHero, Vetor vetor){
        this.tpPiece = tpPiece;
        this.tpHero = tpHero;
        alive = true;
        this.vetor = vetor;
    }
    protected Piece(){
        empty = true;
    }
    //metodos>>
    public abstract void checkMove(Table table);//criação da freeWay
    
    protected void updateHitWay(Table table){//seleciona os vetores de freeWay que possui inimigos
        hitWay.clear();
        for(Block block : freeWay){
            if(table.getBlock(vetor.getX(), vetor.getY()).getPiece().getTpHero() != tpHero){
                hitWay.add(block);
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
        if(hp == 0){
            alive = false;
        }else{
            alive = true;
        }
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
    public PlayerPiece getPlayer() {
        return player;
    }
    public ArrayList<Block> getFreeWay() {
        return freeWay;
    }
    public void ResetPiece() {
        setImage(null);
        
    }
}