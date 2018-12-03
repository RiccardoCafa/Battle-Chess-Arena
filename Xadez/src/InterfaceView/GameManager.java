package InterfaceView;

import businessPack.Block;
import businessPack.Heros.Huebr;
import businessPack.Heros.Lapa;
import businessPack.Piece;
import businessPack.Pieces.Tower;
import businessPack.Player;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameManager {

    
    // Visual Objects to Reference
//    private GridPane gridPane;
//    private Pane pratoPieces;
    
    // Variables declaring
    Vetor myVector;
    Vetor selectedVetor;
    
    private ArrayList<Block> possibleBlocks;
    private ArrayList<Block> possibleHits;
    
    private boolean movingPiece = false;
    private boolean superPower = false;
    //private boolean specialActive = false;
    private boolean combo = false;
    private boolean sheriffTowerReaction;//sheriff power
    
    private String gameName = "System";
    
    private Table table;
    
    private Player player1;
    private Player player2;
    private Player playing;
    
    private GameCtrl gameCtrl;
    
    private Block firstBlock;
    private Block sheriffTowerBlock;
    
    private Tower sheriffTower;
    private Piece pieceMovingImage;
    
    public GameManager(Player p1, Player p2, GameCtrl gameCtrl) {
        this.player1 = p1;
        this.player2 = p2;
        this.gameCtrl = gameCtrl;
        Players.setPlayer1(player1);
        Players.setPlayer2(player2);
        playing = player1;
        table = new Table(8, 8, player1, player2);
        table.setGameCtrl(gameCtrl);
    }
    // >>>> MÉTODOS
    public void GameInit() {
        table.initTable(player1, player2);
    }
     
    public void sheriffTowerShoot(Block actualBlock){//clique extra do tiro da SheriffTower
        if(!combo){//se não se trata de uma reação a uma peça especial
            if(!possibleHits.contains(actualBlock)) return;//o bloco clicado não está dentre as opções
            sheriffTower.realShoot(table, actualBlock);
            sheriffTowerBlock = table.getBlock(sheriffTower);
        }else{//se a peça inimiga é especial, já foi atingida, não morreu, e agora precisa se mover
            if(possibleBlocks.contains(actualBlock)){//se clicou num bloco válido
                externalMove(firstBlock, actualBlock);
                internalMove(firstBlock, actualBlock);
                combo = false;
                sheriffTowerReaction = false;//desativa a reação
                EndOfTurn();
            }else return;
        }
        if(!firstBlock.isEmpty()){//se a reação não matou o atacante
            //ataque inimigo pós-reação
            if(!sheriffTowerBlock.hitPiece(firstBlock.getPiece().getDamage())){//se a peça atingida está viva
                if(firstBlock.getPiece().getTpHero() == TypeHero.lapa){//se a peça atacante é de Lapa
                    Lapa lapa = (Lapa) Players.getActualPlayer().getHero();
                    lapa.setBigBig(lapa.getBigBig() + 1);
                    gameCtrl.displayMessage(playing.getName(),
                                   "Acaba de receber 1 bigbig! Agora ele tem " + lapa.getBigBig() + " bigbigs");
                }
                if(!firstBlock.getPiece().isSpecial()){//se a peça atacante não for especial
                    sheriffTowerReaction = false;//desativa a reação
                    Vetor lastPos = firstBlock.getPiece().getLastPosOf(sheriffTowerBlock);//fica na melhor posição disponível
                    externalMove(firstBlock, table.getBlock(lastPos));
                    internalMove(firstBlock, table.getBlock(lastPos));
                }else{//se a peça atacante é especial
                    possibleBlocks = firstBlock.getPiece().getSpecialMovesLikeJagger(table, sheriffTowerBlock.getVetor());//exibe o novo freeWay
                    if(possibleBlocks.isEmpty()){//se não há lugar para ficar
                        sheriffTower = null;
                        sheriffTowerBlock = null;
                        EndOfTurn();
                        return;
                    }
                    if(possibleBlocks.size() == 1){//se só há uma posição disponível
                        sheriffTower = null;
                        sheriffTowerBlock = null;
                        externalMove(firstBlock, possibleBlocks.get(0));
                        internalMove(firstBlock, possibleBlocks.get(0));
                        EndOfTurn();
                        return;
                    }
                    resetBlockTab();//reseta os highlights
                    showPossibleWays(possibleBlocks);//mostra o novo highlight
                    combo = true;//Torna combo true (no próximo clique, irá pular as ações do início deste método)
                    pieceMovingImage = firstBlock.getPiece();
                }
            }else{//se a peça atingida morreu
                externalMove(firstBlock, sheriffTowerBlock);
                internalMove(firstBlock, sheriffTowerBlock);
                removeImage(sheriffTowerBlock);//remove a imagem do atingido
                sheriffTower = null;
                sheriffTowerBlock = null;
                sheriffTowerReaction = false;
            }
        }else sheriffTowerReaction = false;//desativa a reação
    }
    
    public void firstClick(Block actualBlock){
        if(actualBlock.isEmpty()){//se o bloco está vazio
            firstBlock = null;
            movingPiece = false;
            selectedVetor = null;
            resetBlockTab();
            //System.out.println("Nada aqui");
        }else{//se há peça
            if(playing != actualBlock.getPiece().getPlayer()){//se a peça desse bloco é do outro jogador
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                //System.out.println("Nao é seu turno babaca");
            }else{//se a peça é sua
                combo = false;
                movingPiece = true;
                firstBlock = actualBlock;
                selectedVetor = new Vetor(actualBlock.getVetor());
                showMoves(actualBlock);
            }
        }
    }
    
    public boolean showMoves(Block actualBlock){
        actualBlock.getPiece().checkMove(table);
        possibleBlocks = actualBlock.getPiece().getFreeWay();
        if(possibleBlocks == null || possibleBlocks.isEmpty()){//se o freeWay for vazio ou nulo, saia do evento
            firstBlock = null;
            movingPiece = false;
            selectedVetor = null;
            resetBlockTab();
            //System.out.println("Saindo aqui vlw flw");
            return false;
        }else{
            possibleHits = actualBlock.getPiece().getHitWay();
            showPossibleWays(possibleBlocks);
            showPossibleEnemys(possibleHits);
            //System.out.println("Selected Piece");
            return true;
        }
    }
    
    public void internalMove(Block sourceBlock, Block destinyBlock){
        table.MovePiece(sourceBlock.getVetor(), destinyBlock.getVetor());
        table.getBlock(selectedVetor).colorDefault();
        movingPiece = false;//desabilita a movimentação
        destinyBlock.getPiece().lifeBarRealocate();
        for(int j = destinyBlock.getVetor().getY() + 1; j < 8; j++){
            if(!table.getBlock(destinyBlock.getVetor().getX(), j).isEmpty())
                table.getBlock(destinyBlock.getVetor().getX(), j).getPiece().AllToFront();
        }
        for(int j = destinyBlock.getVetor().getY() - 1; j >= 0; j--){
            if(!table.getBlock(destinyBlock.getVetor().getX(), j).isEmpty())
                table.getBlock(destinyBlock.getVetor().getX(), j).getPiece().AllToBack();
        }
        resetBlockTab();
    }
    
    public void externalMove(Block sourceBlock, Block destinyBlock){
        moveImage(sourceBlock.getVetor(), destinyBlock.getVetor());
        char letraSource, letraDest;
        int numSource, numDest;
        letraSource = (char) (65 + sourceBlock.getVetor().getX());
        letraDest = (char) (65 + destinyBlock.getVetor().getX());
        numDest = destinyBlock.getVetor().getY() + 1;
        numSource = sourceBlock.getVetor().getY() + 1;
        gameCtrl.displayMessage(playing.getName(), "Peça movida de " + letraSource + numSource +
                " para a posição " + letraDest + numDest + "!\n");
    }
       
    
    public void moveImage(Vetor source, Vetor dest) {
        // Pega a peça que está no source
        ImageView pieceToMove = table.getBlock(source).getPiece();
        // Movimenta essa peça
        animation(source, dest, pieceToMove);
        pieceToMove.setLayoutX(65*dest.getX());
        pieceToMove.setLayoutY(-75 + (65*dest.getY()));
    }
    
    public void animation(Vetor source, Vetor destiny, ImageView image){
        int deltaX = destiny.getX() - source.getX();
        int deltaY = destiny.getY() - source.getY();
        TranslateTransition anim = new TranslateTransition();
        for(int i = 1; i <= 4; i++){
            switch(i){
                case 1: anim = new TranslateTransition(Duration.millis(1000), image); break;
                case 2: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getLifeBar()); break;
                case 3: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getLifeBarBg()); break;
                case 4: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getBullet(1)); break;
                case 5: anim = new TranslateTransition(Duration.millis(1000), ((Piece)image).getBullet(2)); break;
            }
            anim.setFromX(-65*deltaX);
            anim.setFromY(-65*deltaY);
            anim.setFromZ(source.getY());
            anim.setToX(0);
            anim.setToY(0);
            anim.setToZ(destiny.getY());
            anim.setCycleCount(1);
            anim.setAutoReverse(true);
            anim.play();
        }
    }
    
    public void OnBlockEnter(MouseEvent e) {
        Block blockOver = (Block) e.getSource();
        if(blockOver.getPiece() != null)
            System.out.println("Essa peça tem " + blockOver.getPiece().getHP());
    }
    
    public void removeImage(Vetor source) {
        Piece pieceToRemove = table.getBlock(source).getPiece();
        pieceToRemove.removePiece();
        pieceToRemove = null;
    }
    
    public void removeImage(Block blockSource){
        try{
            Piece pieceToRemove = blockSource.getPiece();
            pieceToRemove.removePiece();
            pieceToRemove = null;
        }catch(NullPointerException e){ }
    }
    
    public void showPossibleWays(ArrayList<Block> freeWay) {
        if(freeWay == null) {
            return;
        }
        for(Block b : freeWay) {
            b.colorChange(0);
        }
    }
    
    public void showPossibleEnemys(ArrayList<Block> hitWay) {
        if(hitWay == null) {
            return;
        }
        for(Block b : hitWay) {
            b.colorChange(1);
        }
    }
    
    
    public void EndOfTurn() {
        firstBlock = null;
        movingPiece = false;
        selectedVetor = null;
        if(possibleBlocks != null) possibleBlocks.clear();
        possibleHits.clear();
        resetBlockTab();
        playing.getHero().GameManager(table);
        Players.passTurn();
        playing = Players.getTurn() == 1 ? player1 : player2;
        gameCtrl.superPowerBtnManager();
    }
    
    public void resetBlockTab() {
        for(int i = 0; i < Table.getN(); i++) {
            for(int j = 0; j < Table.getM(); j++) {
                table.getBlock(i, j).colorDefault();
            }
        }
    }
    
    public void OnBlockClicked(MouseEvent e) {
        Block actualBlock = (Block) e.getSource();//bloco clicado
        if(sheriffTowerReaction){//sheriff power
            sheriffTowerShoot(actualBlock);
            return;
        }
        if(superPower && playing.getHero().getHeroType() == TypeHero.lapa
                && possibleBlocks.contains(actualBlock)) {
            Lapa lapa = (Lapa) playing.getHero();
            lapa.ExplodeBomb(table, actualBlock.getVetor(), this);
            superPower = false;
            resetBlockTab();
            return;
        }
        if(!combo && !actualBlock.isEmpty() &&                                  //se o bloco clicado não está vazio e
           actualBlock.getBlockState(playing) == BlockState.Friend &&//clicar em uma peça aliada e
           selectedVetor != null){                                  //já tiver sido clicada uma peça
            if(actualBlock != firstBlock){//se a peça clicada for outra aliada
                resetBlockTab();
                movingPiece = false;
            }
        }
        if(!movingPiece){//primeiro clique
            firstClick(actualBlock);
        }else{//segundo clique
            if(actualBlock == firstBlock){//se o bloco é o mesmo clicado antes
                if(combo) return;
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
            }else if(possibleBlocks.contains(actualBlock)){//se é possível se movimentar
                if(!possibleHits.contains(actualBlock)){//se é caminho livre, ou seja, não há inimigos
                    if(combo){
                        externalMove(firstBlock, actualBlock);
                        internalMove(firstBlock, actualBlock);
                        combo = false;
                    }else{
                        externalMove(firstBlock, actualBlock);
                        internalMove(firstBlock, actualBlock);
                    }
                    EndOfTurn();
                }else if(actualBlock.getBlockState(playing) == BlockState.Enemy){//se há inimigo
                    /*
                    HIT
                    */
                    if(actualBlock.getPiece().reaction(table, firstBlock)){//se a reação é da SheriffTower
                        if(possibleHits.size() > 1){//ativa a opção de escolha da reação da SheriffTower
                            sheriffTower = (Tower) actualBlock.getPiece();//guarda a peça
                            sheriffTowerReaction = true;
                            possibleHits = sheriffTower.getSheriffTowerHitWay(table);//mostra as opções de tiro
                            resetBlockTab();
                            showPossibleEnemys(possibleHits);
                            return;
                        }
                    }
                    sheriffTower = null;
                    sheriffTowerReaction = false;
                    if(!firstBlock.isEmpty()){//se a reação não matou o atacante
                        if(!actualBlock.hitPiece(firstBlock.getPiece().getDamage())){ // Hita a peça e retorna se está morto
                            // Está vivo
                            if(firstBlock.getPiece().getTpHero() == TypeHero.lapa) {
                                Lapa lapao = (Lapa) Players.getActualPlayer().getHero();
                                lapao.setBigBig(lapao.getBigBig() + 1);
                                displayMessage(playing.getName(), "Acaba de receber 1 bigbig! Agora ele tem " 
                                        + lapao.getBigBig() + " bigbigs");
                            }
                            if(!firstBlock.getPiece().isSpecial()){ // se a peça não for especial
                                Vetor lastPos = firstBlock.getPiece().getLastPosOf(actualBlock); // Pega a melhor posição para ficar
                                externalMove(firstBlock, table.getBlock(lastPos));
                                internalMove(firstBlock, table.getBlock(lastPos));
                            } else {
                                possibleBlocks = firstBlock.getPiece().getSpecialMovesLikeJagger(table, actualBlock.getVetor()); // Pega o novo free way
                                if(possibleBlocks.isEmpty()) {
                                    EndOfTurn();
                                    return;
                                }
                                if(possibleBlocks.size() == 1) {
                                    externalMove(firstBlock, possibleBlocks.get(0));
                                    internalMove(firstBlock, possibleBlocks.get(0));
                                    EndOfTurn();
                                    return;
                                }
                                resetBlockTab(); // Reseta os highlights
                                showPossibleWays(possibleBlocks); // Mostra o novo highlight
                                combo = true; // Torna combo true
                                pieceMovingImage = firstBlock.getPiece();
                                // TODO CHECAR DEPOIS DE POSSIBLE BLOCKS ESTIVER VAZIO PARA TRATAR ISSO AI 
                                //(isso provavelmente pode ocorrer com peças que pulam)
                            }
                        } else {
                            // Morreu o mizeravel
                            removeImage(actualBlock); // remove a imagem do mizere
                            externalMove(firstBlock, actualBlock);
                            internalMove(firstBlock, actualBlock);
                        }
                    }
                    if(!combo) {
                        EndOfTurn(); // Se não tiver combo, passa o turno
                    }
                }
                /* else { ISSO OCORRE QUANDO NÃO HÁ INIMIGO - ESTÁ INDO PARA UMA POSIÇÃO VAZIA 
                    EndOfTurn();
                }*/
            }else if(actualBlock.isEmpty()){//se está vazio
                if(combo) return;
                firstBlock = null;
                movingPiece = false;
                selectedVetor = null;
                possibleBlocks.clear();
                possibleHits.clear();
                resetBlockTab();
            }
        }
    }
    
    public void displayMessage(String sender, String message) {
        gameCtrl.displayMessage(sender, message);
    }
    
    public void SuperPowerBtn() {
        if(combo) return;
        if(playing.getHero().getHeroType() == TypeHero.lapa && !movingPiece) {
            if(superPower) {
                superPower = false;
                resetBlockTab();
            } else {
                Lapa lapa = (Lapa) playing.getHero();
                if(lapa.getBigBig() >= 5) {
                    possibleBlocks = lapa.getBombWays(table, playing);
                    if(possibleBlocks == null) {
                        return;
                    }
                    displayMessage("Lapa", "Está preparando seus poderosos Bigbigs para atacar!");
                    showPossibleEnemys(possibleBlocks);
                    superPower = true;
                } else {
                    displayMessage(gameName, "Lapa você está sem bigbig, precisa de mais alunos interessados!");
                }
                
            }
            
        }
        
        if(playing.getHero().getHeroType() == TypeHero.huebr && !movingPiece) {
            Huebr huebr = (Huebr) playing.getHero();
            huebr.setUsePower(true);
            displayMessage("Lapa", "Huebr acaba de causar problemas! Joga dois turnos!");
            System.out.println("Power ativado");
        }
    }
    
    // >>>> GETSET
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public Table getTable() {
        return table;
    }

    /**
     * @return the possibleBlocks
     */
    public ArrayList<Block> getPossibleBlocks() {
        return possibleBlocks;
    }

    /**
     * @param possibleBlocks the possibleBlocks to set
     */
    public void setPossibleBlocks(ArrayList<Block> possibleBlocks) {
        this.possibleBlocks = possibleBlocks;
    }

    /**
     * @return the possibleHits
     */
    public ArrayList<Block> getPossibleHits() {
        return possibleHits;
    }

    /**
     * @param possibleHits the possibleHits to set
     */
    public void setPossibleHits(ArrayList<Block> possibleHits) {
        this.possibleHits = possibleHits;
    }

    /**
     * @return the sheriffTowerReaction
     */
    public boolean isSheriffTowerReaction() {
        return sheriffTowerReaction;
    }

    /**
     * @param sheriffTowerReaction the sheriffTowerReaction to set
     */
    public void setSheriffTowerReaction(boolean sheriffTowerReaction) {
        this.sheriffTowerReaction = sheriffTowerReaction;
    }
    
    /**
     * @return the gridPane
     */
    public GridPane getGridPane() {
        return gameCtrl.gridPane;
    }

    /**
     * @return the pratoPieces
     */
    public Pane getPratoPieces() {
        return gameCtrl.pratoPieces;
    }
}
