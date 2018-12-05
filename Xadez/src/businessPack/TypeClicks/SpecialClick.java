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
        System.out.println("special");
        if(game.getSheriffBlock() != null) blockClicked = game.getSheriffBlock();
        game.setPossibleBlocks(priorBlockClicked.getPiece().getSpecialMovesLikeJagger(game.getTable(), blockClicked.getVetor()));
        if(game.getPossibleBlocks().isEmpty()){
            game.setSheriffBlock(null);
            game.setClickSequence(true);
            return TypeClick.last;
        }
        if(game.getPossibleBlocks().size() == 1){
            game.externalMove(priorBlockClicked, game.getPossibleBlocks().get(0));
            game.internalMove(priorBlockClicked, game.getPossibleBlocks().get(0));
            game.setSheriffBlock(null);
            game.setClickSequence(true);
            return TypeClick.last;
        }
        game.clearHighlight();
        game.showPossibleWays(game.getPossibleBlocks());
        game.setClickSequence(false);
        return TypeClick.moveSpecial;
    }
}