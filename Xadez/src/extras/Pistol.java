package extras;

import businessPack.Block;
import businessPack.Table;
import javafx.scene.image.ImageView;

public interface Pistol {
    //metodos>>
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock, boolean protectQueen);
    public void recharge();
}
