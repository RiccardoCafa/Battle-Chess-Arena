package businessPack;

/**
 * @author patri
 */
public class Player {
    //atributos>>
    //Character char;
    Army army;
    int sentido;//se começa embaixo, -1; se começa em cima, 1
    //construtor>>
    public Player(int sentido) {
        army = new Army(/*char*/);
        this.sentido = sentido;
    }
    //metodos>>
    
    //getset>>
    public Army getArmy() {
        return army;
    }
}
