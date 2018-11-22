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
    protected Who player;
    protected int hp;
    protected int damage = 1;
    protected final float widhtImg = 60f;
    protected final float heightImg = 130;
    protected boolean alive;
    protected boolean especial;
    protected String pathHero;
    protected Vetor vetor;
    protected ArrayList<Block> freeWay;
    protected ArrayList<Block> hitWay;
    protected ArrayList<Block> especialFreeWay;
    protected ArrayList<Block> especialHitWay;
    //construtor>>
    protected Piece(Who player, TypeHero tpHero, int x, int y){
        this.tpHero = tpHero;
        this.player = player;
        alive = true;
        vetor = new Vetor(x, y);
        pathHero = getHeroPath();
        setPickOnBounds(true);
        setMouseTransparent(true);
        especial = false;
//        setLayoutX(20);
//        setLayoutY(0);
    }
    protected Piece(TypePiece tpPiece, TypeHero tpHero, Vetor vetor){
        this.tpPiece = tpPiece;
        this.tpHero = tpHero;
        alive = true;
        this.vetor = vetor;
        pathHero = getHeroPath();
        setPickOnBounds(true);
        setMouseTransparent(true);
        especial = false;
//        setLayoutX(20);
//        setLayoutY(0);
    }
    //metodos>>
    public abstract void checkMove(Table table);//criação da freeWay
    public void checkEspecialMove(Table table, Block tempLocation){
        if(especial){
            especialFreeWay = new ArrayList<>();
            especialFreeWay.clear();
            //table.clearTrend();
            Block addBlock;
            for(int i = 1; i < 9; i++){
                try{
                    addBlock = table.getBlock(tempLocation.getVetor().getX() + Vetor.getTrend(i).getX(),
                                              tempLocation.getVetor().getY() + Vetor.getTrend(i).getY());
                    if(addBlock.getBlockState(Players.getPlayer(player)) != BlockState.Friend)
                        freeWay.add(addBlock);
                }catch(NullPointerException e){
                    System.out.println("deu erro em " + i);
                }
            }
            freeWay = strategy.IcheckMove(table, vetor);
            updateHitWay();
        }else{
            especialFreeWay = null;
        }
    }
    public boolean hit(int damage){
        setHP(hp - damage);
        return alive;
    }
    public void reaction(Table table){
        strategy.Ireaction(table, vetor);
    }
    protected void updateHitWay(){//seleciona os vetores de freeWay que possui inimigos
        hitWay = new ArrayList<>();
        if(hitWay != null) hitWay.clear(); else return;
        for(Block block : freeWay){
            if(block.getBlockState(Players.getPlayer(player)) == BlockState.Enemy){
                hitWay.add(block);
            }
        }
    }
    public ArrayList<Block> updateHitWay(Table table, ArrayList<Block> freeWay){//seleciona os vetores de freeWay que possui inimigos
        hitWay = new ArrayList<>();
        if(hitWay != null) hitWay.clear();
        if(freeWay != null){
            for(Block block : freeWay){
                if(block.getBlockState(Players.getPlayer(player)) == BlockState.Enemy){
                    hitWay.add(block);
                }
            }
        }
        return hitWay;
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
    public boolean imAlive(){
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
    public Who getWho() {
        return player;
    }
    public Player getPlayer() {
        return Players.getPlayer(player);
    }
    public ArrayList<Block> getFreeWay() {
        return freeWay;
    }
    public ArrayList<Block> getHitWay() {
        return hitWay;
    }
    public boolean isSpecial(){
        return especial;
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
        return null;
    }
}