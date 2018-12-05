package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;
import businessPack.Heros.Wizard;
import businessPack.Players;
import extras.Vetor;

public class WizardClick implements ClickOnBlock {

    GameManager gameManager;
    
    public WizardClick(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    
    @Override
    public TypeClick click(Block blockClicked) {
        if(gameManager.getPossibleBlocks().contains(blockClicked)) {
            Wizard wiz = (Wizard) Players.getActualPlayer().getHero();
            wiz.setWall(blockClicked.getVetor());
            wiz.setWallSetted(true);
        }
        gameManager.setClickSequence(false);
        gameManager.clearHighlight();
        return TypeClick.first;
    }
    
}
