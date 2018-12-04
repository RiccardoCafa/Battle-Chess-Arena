package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;

public class MoveClick implements ClickOnBlock{
    //atributos>>
    GameManager game;
    Block priorBlockClicked;
    //construtor>>
    public MoveClick(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        if(game.getPossibleBlocks().contains(blockClicked)){//se o bloco clicado é válido para mover
            if(game.getPossibleHits().contains(blockClicked)){
                game.setClickSequence(true);
                return TypeClick.hit;
            }
            game.externalMove(priorBlockClicked, blockClicked);
            game.internalMove(priorBlockClicked, blockClicked);
            game.clearHighlight();
            game.setClickSequence(true);
            return TypeClick.last;
        }else{//se o bloco clicado não está entre as opções
            game.clearHighlight();
            game.setClickSequence(false);
            return TypeClick.first;
        }
    }
}