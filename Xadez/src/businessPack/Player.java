package businessPack;

/**
 * @author patri
 */
public class Player {
    //atributos>>
    private Army army;
    private Hero hero;
    private int sentido;//se começa embaixo, -1; se começa em cima, 1
    //construtor>>
    public Player(int sentido, Hero hero) {
        this.hero = hero;
        hero.createArmy(army, sentido);
        this.sentido = sentido;
    }
    //metodos>>
    
    //getset>>
    public Army getArmy() {
        return army;
    }
}
