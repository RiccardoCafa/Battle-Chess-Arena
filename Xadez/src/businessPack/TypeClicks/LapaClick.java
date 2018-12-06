package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;
import businessPack.Heros.Lapa;

public class LapaClick implements ClickOnBlock {

    private GameManager game;
    private Lapa lapa;
    
    public LapaClick(GameManager game, Lapa lapa) {
        this.game = game;
        this.lapa = lapa;
    }
    
    @Override
    public TypeClick click(Block blockClicked) {
        
        if(game.getPossibleBlocks().contains(blockClicked)) {
            lapa.ExplodeBomb(game.getTable(), blockClicked.getVetor(), game);
            game.setClickSequence(false);
            game.clearHighlight();
            return TypeClick.first;
        }
        game.setClickSequence(false);
        return TypeClick.lapaClick;
    }
    
}
