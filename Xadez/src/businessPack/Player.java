package businessPack;

import extras.PlayerPiece;

/**
 * @author patri
 */
public class Player {
    //atributos>>
    private PlayerPiece jogador;
    private Army army;
    private Hero hero;
    private int playingTurn;
    private int sentido;//se começa embaixo, -1; se começa em cima, 1
    //construtor>>
    public Player(int sentido, Hero hero, int playingTurn) {
        this.hero = hero;
        this.jogador = jogador;
        this.playingTurn = playingTurn;
        hero.createArmy(army, sentido,jogador);
        //hero.createArmy(army, sentido);
        this.sentido = sentido;
    }
    //metodos>>
    
    //getset>>
    public Army getArmy() {
        return army;
    }
    
    public int getPlayingTurn() {
        return playingTurn;
    }
}
