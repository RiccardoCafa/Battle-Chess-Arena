package businessPack;

/**
 * @author patri
 */
public class Player {
    Character personagemPlayer;
    Exercito exercito;
 
    public Player() {
        exercito = new Exercito();
        //personagemPlayer = new Character();
    }
    
    public Exercito getExercito() {
        return exercito;
    }
}
