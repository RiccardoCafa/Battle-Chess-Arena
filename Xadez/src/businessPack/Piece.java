package businessPack;

import businessPack.Heros.Wizard;
import InterfaceView.GameManager;
import extras.BlockState;
import businessPack.Pieces.Sheriff.Pistol;
import extras.Who;
import java.util.ArrayList;
import extras.Vetor;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import businessPack.Pieces.Interfaces.IMovement;
import businessPack.Pieces.Sheriff.SheriffTower;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public abstract class Piece extends ImageView {
    //atributos>>
    protected TypePiece tpPiece;
    protected IMovement strategy;//agora o strategy vem de Piece
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
    protected ImageView[] bullet;//sheriff atribute
    protected ArrayList<Block> freeWay;
    protected ArrayList<Block> hitWay;
    protected ArrayList<Block> especialFreeWay;
    protected ArrayList<Block> especialHitWay;
    protected Pistol shoot;//sheriff atribute
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
        setTranslateZ((double)vetor.getY());
        lifeBar = new ImageView(new Image("InterfaceView/imagens/barraVerde.png", 60, 10, false, false));
        imageConfig(lifeBar, "InterfaceView/imagens/barraVerde.png", 60, 10, false);
        lifeBarBg = new ImageView(new Image("InterfaceView/imagens/barraVermelha.png", 60, 10, false, false));
        imageConfig(lifeBarBg, "InterfaceView/imagens/barraVermelha.png", 60, 10, true);
        bullet = new ImageView[2];
        bullet[0] = new ImageView(new Image("InterfaceView/imagens/bullet.png", 13, 30, false, false));
        imageConfig(bullet[0], "InterfaceView/imagens/bullet.png", 13, 30, true);
        bullet[1] = new ImageView(new Image("InterfaceView/imagens/bullet.png", 13, 30, false, false));
        imageConfig(bullet[1], "InterfaceView/imagens/bullet.png", 13, 30, true);
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
        setTranslateZ(vetor.getY());
        lifeBar = new ImageView(new Image("InterfaceView/imagens/barraVerde.png", 60, 10, false, false));
        imageConfig(lifeBar, "InterfaceView/imagens/barraVerde.png", 60, 10, false);
        lifeBarBg = new ImageView(new Image("InterfaceView/imagens/barraVermelha.png", 60, 10, false, false));
        imageConfig(lifeBarBg, "InterfaceView/imagens/barraVermelha.png", 60, 10, true);
        bullet = new ImageView[2];
        bullet[0] = new ImageView(new Image("InterfaceView/imagens/bullet.png", 13, 30, false, false));
        imageConfig(bullet[0], "InterfaceView/imagens/bullet.png", 13, 30, true);
        bullet[1] = new ImageView(new Image("InterfaceView/imagens/bullet.png", 13, 30, false, false));
        imageConfig(bullet[1], "InterfaceView/imagens/bullet.png", 13, 30, true);
    }
    //metodos>>
    private void imageConfig(ImageView image, String path, double width, double height, boolean ratio){
        image.setPreserveRatio(ratio);
        image.setFitWidth(width);
        image.setFitHeight(height);
        image.setMouseTransparent(true);
    }
    public abstract void checkMove(Table table);//criação da freeWay
    public void recharge(){ }
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
    public boolean reaction(Table table, Block enemyBlock){//sheriff method
        if(tpHero == TypeHero.sheriff && tpPiece != TypePiece.bishop)
            return shoot.reaction(table, vetor, enemyBlock);
        else
            return false;
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
    public void lifeBarRealocate(){
        lifeBar.setLayoutX((65 * vetor.getX()) - (1 - ((float)hp/(float)maxHp))*30);
        lifeBarBg.setLayoutX(65 * vetor.getX());
        lifeBar.setLayoutY(-90 + (65 * vetor.getY()));
        if(tpPiece == TypePiece.peon || tpPiece == TypePiece.horse || tpPiece == TypePiece.tower) {
            lifeBar.setLayoutY(lifeBar.getLayoutY() + 30);
        }
        lifeBarBg.setLayoutY(lifeBar.getLayoutY());
        bulletViewConfig();
    }
    public void lifeBarResize() {
        lifeBar.setScaleX((float)hp / (float)maxHp);
    }
    public void bulletViewConfig(){
        bullet[0].setLayoutX(00 + 65*vetor.getX());
        bullet[0].setLayoutY(30 + 65*vetor.getY());
        bullet[0].setTranslateZ(vetor.getY());
        bullet[1].setLayoutX(17 + 65*vetor.getX());
        bullet[1].setLayoutY(30 + 65*vetor.getY());
        bullet[1].setTranslateZ(vetor.getY());
    }
    public void removePiece() {
        lifeBar.setVisible(false);
        lifeBarBg.setVisible(false);
        bullet[0].setVisible(false);
        bullet[1].setVisible(false);
        setVisible(false);
    }
    public void AllToFront(){
        toFront();
        lifeBarBg.toFront();
        lifeBar.toFront();
        bullet[0].toFront();
        bullet[1].toFront();
    }
    public void AllToBack(){
        lifeBar.toBack();
        lifeBarBg.toBack();
        bullet[0].toBack();
        bullet[1].toBack();
        toBack();
    }
    //getset>>
    public Pistol getShoot(GameManager game, Block priorBlockClicked){
        ((SheriffTower)shoot).setTurnAtributes(game, priorBlockClicked);
        return shoot;
    }
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
    public ImageView getBullet(int i){
        try{
            return bullet[i - 1];
        }catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    public boolean hit(int damage){
        setHP(hp - damage);
        if(!alive) {
            if(getTypePiece() == TypePiece.peon && 
               Players.getAdversaryPlayer().getHero() instanceof Wizard) {
               Wizard wiz = (Wizard)Players.getAdversaryPlayer().getHero();
               wiz.setCanMove(true);
               if(wiz.getCanMove()){
                   wiz.setCanMove(false);
               }
            }
            removePiece();
        }
        lifeBarResize();
        lifeBarRealocate();
        bulletViewConfig();
        return alive;
    }
    public boolean setHP(int hp){
        if(hp>maxHp){
            hp = maxHp;
        }
        this.hp = hp;
        if(hp <= 0) alive = false;
        return alive;
    }
    public void healPiece(int hp){
        this.hp += hp ;
        if(this.hp>maxHp){
            this.hp =  maxHp;
        }
        System.out.println("New hp: " + this.hp);
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
    public TypePiece getTypePiece(){
        return tpPiece;
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
    public void setStrategy(IMovement strategy){
        this.strategy = strategy;
    }
    public String getPieceName() {
        return pieceName;
    }
    public boolean isSpecial(){
        return especial;
    }
    public abstract IMovement getHeroStrategy();
    
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