package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Players;
import businessPack.TypeHero;
import extras.Vetor;

public class ReactionClick implements ClickOnBlock{
    //atributos>>
    GameManager game;
    Block priorBlockClicked;
    //construtor>>
    public ReactionClick(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        if(blockClicked.getPiece().reaction(game.getTable(), priorBlockClicked)){//se a reação é da SheriffTower
            game.setSheriffBlock(blockClicked);
            game.setClickSequence(true);
            return TypeClick.sheriffTower;
        }
        if(!priorBlockClicked.isEmpty()){//se a reação não matou o atacante
            game.setClickSequence(true);
            return TypeClick.hit;
        }else{//se a reação matou o atacante
            game.removeImage(priorBlockClicked);
            game.setClickSequence(true);
            return TypeClick.last;
        }
    }
}