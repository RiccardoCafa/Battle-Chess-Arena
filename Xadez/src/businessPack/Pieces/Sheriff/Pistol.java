package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Table;
import extras.Vetor;

public interface Pistol {
    //atributos>>
    PistolSound MP3 = new PistolSound();
    //metodos>>
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock);
    public void recharge();
}