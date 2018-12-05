package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;

public class MoveSpecialClick implements ClickOnBlock{
    //atributos>>
    GameManager game;
    Block priorBlockClicked;
    //construtor>>
    public MoveSpecialClick(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        if(game.getPossibleBlocks().contains(blockClicked)){//se o bloco clicado é válido para mover
            game.externalMove(priorBlockClicked, blockClicked);
            game.internalMove(priorBlockClicked, blockClicked);
            game.clearHighlight();
            game.setSheriffBlock(null);
            game.setClickSequence(true);
            return TypeClick.last;
        }else{//se o bloco clicado não está entre as opções
            game.setClickSequence(false);
            return TypeClick.moveSpecial;
        }
    }
}