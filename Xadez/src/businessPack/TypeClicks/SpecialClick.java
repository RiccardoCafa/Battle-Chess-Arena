package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;

public class SpecialClick implements ClickOnBlock{
    //atributos>>
    GameManager game;
    Block priorBlockClicked;
    //construtor>>
    public SpecialClick(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        game.setPossibleBlocks(priorBlockClicked.getPiece().getSpecialMovesLikeJagger(game.getTable(), blockClicked.getVetor()));
        if(game.getPossibleBlocks().isEmpty()) {
            game.setClickSequence(true);
            return TypeClick.last;
        }
        if(game.getPossibleBlocks().size() == 1) {
            game.externalMove(priorBlockClicked, game.getPossibleBlocks().get(0));
            game.internalMove(priorBlockClicked, game.getPossibleBlocks().get(0));
            game.setClickSequence(true);
            return TypeClick.last;
        }
        game.clearHighlight();
        game.showPossibleWays(game.getPossibleBlocks());
        game.setClickSequence(false);
        return TypeClick.moveSpecial;
    }
}