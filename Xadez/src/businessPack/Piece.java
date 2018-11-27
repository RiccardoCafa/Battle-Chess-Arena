package businessPack;

import businessPack.Pieces.Interfaces.ItypePiece;
import extras.BlockState;
import extras.Who;
import java.util.ArrayList;
import extras.Vetor;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView {
    //atributos>>
    protected TypePiece tpPiece;
    protected ItypePiece strategy;//agora o strategy vem de Piece
    protected TypeHero tpHero;
    protected Who player;
    protected int hp;
    protected int maxHp;
    protected int damage = 1;
    protected final float widhtImg = 60f;
    protected final float heightImg = 130;
    protected boolean alive;
    protected boolean especial;
    protected String pathHero;
    protected String pieceName;
    protected Vetor vetor;
    private ImageView lifeBar;
    private ImageView lifeBarBg; 
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
        lifeBar = new ImageView(new Image("InterfaceView/imagens/barraVerde.png", 60, 10, false, false));
        lifeBarBg = new ImageView(new Image("InterfaceView/imagens/barraVermelha.png", 60, 10, false, false));
        lifeBar.setPreserveRatio(false);
        lifeBar.setFitWidth(60);
        lifeBar.setFitHeight(10);
        lifeBarBg.setFitWidth(60);
        lifeBarBg.setFitHeight(10);
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
        lifeBar = new ImageView(new Image("InterfaceView/imagens/barraVerde.png", 60, 10, false, false));
        lifeBarBg = new ImageView(new Image("InterfaceView/imagens/barraVermelha.png", 60, 10, false, false));
        lifeBar.setPreserveRatio(false);
        lifeBar.setFitWidth(60);
        lifeBar.setFitHeight(10);
        lifeBarBg.setFitWidth(60);
        lifeBarBg.setFitHeight(10);
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
                        especialFreeWay.add(addBlock);
                }catch(NullPointerException e){
                    System.out.println("deu erro em " + i);
                }
            }
            especialFreeWay = strategy.IcheckMove(table, vetor);
            especialHitWay = updateHitWay(table, especialFreeWay);
        }else{
            especialFreeWay = null;
        }
    }
    public Vetor getLastPosOf(Block hitedBlock) {
        
        if(tpPiece == TypePiece.horse) {
            return vetor;
        }
        
        if(Math.abs(vetor.getX() - hitedBlock.getVetor().getX()) <= 1 &&
            Math.abs(vetor.getY() - hitedBlock.getVetor().getY()) <= 1) {
            return vetor;
        }
        
        ArrayList<Block> tempFreeWay = new ArrayList<>();
        tempFreeWay.addAll(freeWay);
        //System.out.println("Tamanho de temp: " + tempFreeWay.size());
        //System.out.println("Tamanho de freeWay: " + freeWay.size());
        int indexOfEnemy = freeWay.indexOf(hitedBlock);
        //System.out.println("Index encontrado em: " + indexOfEnemy);
        for(Block b : hitWay) {
            if(tempFreeWay.contains(b)) tempFreeWay.remove(b);
        }
        if(tempFreeWay.isEmpty()) {
            System.out.println("temp vazio");
            return getVetor();
        }
        indexOfEnemy--;
        if(indexOfEnemy < 0) indexOfEnemy = 0;
        //System.out.println("Pegando index do enemy");
        return freeWay.get(indexOfEnemy).getVetor();
    }
    public ArrayList<Block> getSpecialMovesLikeJagger(Table tab, Vetor hitedPos) {
        freeWay = new ArrayList<>();
        JaggerMoves(tab, hitedPos, 1, 0);
        JaggerMoves(tab, hitedPos, -1, 0);
        JaggerMoves(tab, hitedPos, 0, 1);
        JaggerMoves(tab, hitedPos, 0, -1);
        JaggerMoves(tab, hitedPos, 1, 1);
        JaggerMoves(tab, hitedPos, -1, 1);
        JaggerMoves(tab, hitedPos, 1, -1);
        JaggerMoves(tab, hitedPos, -1, -1);
        return freeWay;
    }
    private void JaggerMoves(Table tab, Vetor hitedPos, int xDir, int yDir) {
        Vetor vet = new Vetor(hitedPos.getX() + xDir, hitedPos.getY() + yDir);
        Player maPlayer = Players.getPlayer(player);
        if(Table.isInside(vet)) {
            if(tab.getBlock(vet).getBlockState(maPlayer) == BlockState.Empty) {
                freeWay.add(tab.getBlock(vet));
                
            }
        }
    }
    public void reaction(Table table){
        strategy.Ireaction(table, vetor);
    }
    protected void updateHitWay(){//seleciona os vetores de freeWay que possui inimigos
        hitWay = new ArrayList<>();
        if(hitWay != null) hitWay.clear(); else return;
        if(freeWay == null) return;
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
    public void lifeBarToFront() {
        lifeBarBg.toFront();
        lifeBar.toFront();
    }
    public void lifeBarToBack() {
        lifeBar.toBack();
        lifeBarBg.toBack();
    }
    public void lifeBarRealocate() {
        lifeBar.setLayoutX((65 * vetor.getX()) - (1 - ((float)hp/(float)maxHp))*30);
        lifeBarBg.setLayoutX(65 * vetor.getX());
        lifeBar.setLayoutY(-90 + (65 * vetor.getY()));
        if(tpPiece == TypePiece.peon || tpPiece == TypePiece.horse || tpPiece == TypePiece.tower) {
            lifeBar.setLayoutY(lifeBar.getLayoutY() + 30);
        }
        lifeBarBg.setLayoutY(lifeBar.getLayoutY());
    }
    public void lifeBarResize() {
        lifeBar.setScaleX((float)hp / (float)maxHp);
    }
    //getset>>
    public TypePiece getPiece(){
        return tpPiece;
    }
    public int getHP(){
        return hp;
    }
    public ImageView getLifeBar() {
        return lifeBar;
    }
    public ImageView getLifeBarBg() {
        return lifeBarBg;
    }
    public boolean hit(int damage){
        setHP(hp - damage);
        lifeBarResize();
        lifeBarRealocate();
        return alive;
    }
    private void setHP(int hp){
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
    public ArrayList<Block> getEspecialFreeWay() {
        return especialFreeWay;
    }
    public ArrayList<Block> getEspecialHitWay() {
        return especialHitWay;
    }
    public void setStrategy(ItypePiece strategy){
        this.strategy = strategy;
    }
    public String getPieceName() {
        return pieceName;
    }
    public boolean isSpecial(){
        return especial;
    }
    public void removePiece() {
        lifeBar.setVisible(false);
        lifeBarBg.setVisible(false);
        setVisible(false);
    }
    public abstract ItypePiece getHeroStrategy();
    
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