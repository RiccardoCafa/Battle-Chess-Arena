package businessPack.TypeClicks;

import InterfaceView.GameCtrl;
import InterfaceView.GameManager;
import businessPack.Block;
import extras.Vetor;

public class FirstClick implements ClickOnBlock {
    //atributos>>
    GameManager game;
    //construtor>>
    public FirstClick(GameManager game){
        this.game = game;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        game.clearHighlight();
        game.setClick1(blockClicked);
        if(blockClicked.isEmpty() ||//se o bloco está vazio ou
           game.getPlaying() != blockClicked.getPiece().getPlayer()){//se a peça desse bloco é do outro jogador
            game.setClickSequence(false);
            return TypeClick.first;
        }else{//se o bloco tem uma peça sua
            game.setClickSequence(false);
            return game.showMoves(blockClicked);
        }
    }
}