package businessPack;

import extras.Who;
import java.util.ArrayList;
import extras.Vetor;
import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView {
    //atributos>>
    protected TypePiece tpPiece;
    protected TypeHero tpHero;
    protected Player player;
    protected int hp;
    protected int damage = 1;
    protected boolean alive;
    protected String pathHero;
    protected Vetor vetor;
    protected ArrayList<Block> freeWay;
    protected ArrayList<Block> hitWay;
    //construtor>>
    protected Piece(Player player, TypeHero tpHero, int x, int y){
        this.tpHero = tpHero;
        this.player = player;
        alive = true;
        vetor = new Vetor(x, y);
        pathHero = getHeroPath();
        setMouseTransparent(true);
        setLayoutX(2.5);
        setLayoutY(-75);
    }
    protected Piece(TypePiece tpPiece, TypeHero tpHero, Vetor vetor){
        this.tpPiece = tpPiece;
        this.tpHero = tpHero;
        alive = true;
        this.vetor = vetor;
        pathHero = getHeroPath();
        setMouseTransparent(true);
        setLayoutX(2.5);
        setLayoutY(-75);
    }
    //metodos>>
    public abstract void checkMove(Table table);//criação da freeWay
    
    protected void updateHitWay(Table table){//seleciona os vetores de freeWay que possui inimigos
        if(hitWay != null) hitWay.clear();
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
    public void hit(int damage, Table table){
        hp -= damage;
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
    public void setVetor(Vetor v){
        this.vetor = v;
    }
    public TypeHero getTpHero(){
        return tpHero;
    }
    public Who getPlayer() {
        return player.getWho();
    }
    public ArrayList<Block> getFreeWay() {
        return freeWay;
    }
    private String getHeroPath() {
        switch(tpHero) {
            case huebr:
                return "huebr";
            case lapa:
                return "lapa";
            case lenin:
                return "lenin";
            case sheriff:
                return "sheriff";
            case wizard:
                return "wizard";
        }
        return "huebr";
    }
}