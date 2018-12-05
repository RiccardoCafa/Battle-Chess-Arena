package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;
import businessPack.Players;

public class LastClick implements ClickOnBlock{
    //atributos>>
    GameManager game;
    //construtor>>
    public LastClick(GameManager game){
        this.game = game;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked) {
        //if(game.getPossibleBlocks() != null) game.getPossibleBlocks().clear();
        //game.getPlaying().getHero().GameManager(game.getTable());
        //Players.passTurn();
        //game.setPlaying(Players.getTurn() == 1 ? game.getPlayer1() : game.getPlayer2());
        //game.getGameCtrl().superPowerBtnManager();
        //game.clearHighlight();
        game.EndOfTurn();
        game.setClickSequence(false);
        return TypeClick.first;
    }
}