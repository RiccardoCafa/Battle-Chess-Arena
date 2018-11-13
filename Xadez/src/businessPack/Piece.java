package businessPack;

import extras.Who;
import java.util.ArrayList;
import javafx.scene.image.Image;
import extras.Vetor;

public abstract class Piece {
    //atributos>>
    protected TypePiece tpPiece;
    protected TypeHero tpHero;
    protected Player player;
    protected Image image;
    protected int hp;
    protected boolean alive;
    protected int damage = 1;
    protected Vetor vetor;
    protected ArrayList<Block> freeWay;
    protected ArrayList<Block> hitWay;
    //construtor>>
    protected Piece(Player player, TypeHero tpHero, int x, int y){
        this.tpHero = tpHero;
        this.player = player;
        alive = true;
        vetor = new Vetor(x, y);
    }
    protected Piece(TypePiece tpPiece, TypeHero tpHero, Vetor vetor){
        this.tpPiece = tpPiece;
        this.tpHero = tpHero;
        alive = true;
        this.vetor = vetor;
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
    public Who getPlayer() {
        return player.getWho();
    }
    public ArrayList<Block> getFreeWay() {
        return freeWay;
    }
     /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
}