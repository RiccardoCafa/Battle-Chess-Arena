package businessPack.TypeClicks;

import InterfaceView.GameCtrl;
import InterfaceView.GameManager;
import businessPack.Block;
import extras.Vetor;

public class FirstClick implements ClickOnBlock {
    //atributos>>
    GameManager game;
    Block priorBlockClicked;
    //construtor>>
    public FirstClick(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        game.clearHighlight();
        game.setClick1(blockClicked);
        if(blockClicked == priorBlockClicked){//se a mesma peça foi clicada de novo
            game.clearHighlight();
            game.setClick1(null);
            game.setClickSequence(false);
            return TypeClick.first;
        }
        if(blockClicked.isEmpty() ||//se o bloco está vazio ou
           game.getPlaying() != blockClicked.getPiece().getPlayer()){//se a peça desse bloco é do outro jogador
            game.setClick1(null);
            game.setClickSequence(false);
            return TypeClick.first;
        }else{//se o bloco tem uma peça sua
            game.setClick1(blockClicked);
            game.setClickSequence(false);
            return game.showMoves(blockClicked);
        }
    }
}