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
                return TypeClick.reaction;
            }
            game.externalMove(priorBlockClicked, blockClicked);
            game.internalMove(priorBlockClicked, blockClicked);
            game.clearHighlight();
            game.setClickSequence(true);
            return TypeClick.last;
        }else if(blockClicked.isEmpty() ||//se clicou num lugar vazio ou 
                 blockClicked.getPiece().getTpHero() != priorBlockClicked.getPiece().getTpHero()){//clicou nunm inimigo inválido
            game.clearHighlight();
            game.setClick1(null);
            game.setClickSequence(false);
            return TypeClick.first;
        }else{//se clicou num aliado
            game.clearHighlight();
            game.setClickSequence(true);
            return TypeClick.first;
        }
    }
}