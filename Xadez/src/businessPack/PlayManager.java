
package businessPack;

import java.util.Random;


public class PlayManager {/* Fazer os controles principais do jogo */
    
    /* Deixar aleatorio quem começa o jogo */
    Random random = new Random();
    int vezPlayer = random.nextInt(2) + 1;
}
