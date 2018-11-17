package businessPack;

import businessPack.Pieces.Interfaces.ItypePiece;
import extras.BlockState;
import extras.Who;
import java.util.ArrayList;
import extras.Vetor;
import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView {
    //atributos>>
    protected TypePiece tpPiece;
    protected ItypePiece strategy;//agora o strategy vem de Piece
    protected TypeHero tpHero;
    protected Player player;
    protected int hp;
    protected int damage = 1;
    protected final float widhtImg = 26.5f;
    protected final float heightImg = 60;
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
        setPickOnBounds(true);
        setMouseTransparent(true);
        setLayoutX(20);
        setLayoutY(0);
    }
    protected Piece(TypePiece tpPiece, TypeHero tpHero, Vetor vetor){
        this.tpPiece = tpPiece;
        this.tpHero = tpHero;
        alive = true;
        this.vetor = vetor;
        pathHero = getHeroPath();
        setPickOnBounds(true);
        setMouseTransparent(true);
        setLayoutX(20);
        setLayoutY(0);
    }
    //metodos>>
    public abstract void checkMove(Table table);//criação da freeWay
    public void hit(int damage){
        setHP(hp - damage);
    }
    public void reaction(Table table){
        table = strategy.Ireaction(table, vetor);
    }
    protected void updateHitWay(Table table){//seleciona os vetores de freeWay que possui inimigos
        hitWay = new ArrayList<>();
        if(hitWay != null) hitWay.clear();
        for(Block block : freeWay){
            if(block.getBlockState(player) == BlockState.Enemy){
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
        alive = (hp > 0);
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
    public Who getPlayerWho() {
        return player.getWho();
    }
    public Player getPlayer() {
        return player;
    }
    public ArrayList<Block> getFreeWay() {
        return freeWay;
    }
    public ArrayList<Block> getHitWay() {
        return hitWay;
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