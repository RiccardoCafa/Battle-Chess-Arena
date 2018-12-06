package businessPack.TypeClicks;

import InterfaceView.GameManager;
import businessPack.Block;
import businessPack.Heros.Lapa;
import businessPack.Piece;
import businessPack.Pieces.Peon;
import businessPack.Pieces.Tower;
import businessPack.Players;
import businessPack.TypeHero;
import extras.Vetor;

public class HitClick implements ClickOnBlock{
    //atributos>>
    
    GameManager game;
    Block priorBlockClicked;
    
    //construtor>>
    public HitClick(GameManager game, Block priorBlockClicked){
        this.game = game;
        this.priorBlockClicked = priorBlockClicked;
    }
    //metodos>>
    @Override
    public TypeClick click(Block blockClicked){
        Piece tempPiece;
        if(game.getSheriffBlock() != null) blockClicked = game.getSheriffBlock();
        if(priorBlockClicked != null){//se a peça atacante não morreu
            tempPiece = blockClicked.getPiece();
            if(!blockClicked.hitPiece(priorBlockClicked.getPiece().getDamage())){//atinge a peça; se estiver viva...
                if(priorBlockClicked.getPiece().getTpHero() == TypeHero.lapa){
                    Lapa lapao = (Lapa) Players.getActualPlayer().getHero();
                    lapao.setBigBig(lapao.getBigBig() + 1);
                    game.displayMessage(game.getPlaying().getName(), "Acaba de receber 1 bigbig! Agora ele tem " 
                            + lapao.getBigBig() + " bigbigs");
                }
                game.clearHighlight();
                if(priorBlockClicked.getPiece().isSpecial()){//se a peça for especial
                    game.setClickSequence(true);
                    return TypeClick.special;
                }else{//se não for especial
                    Vetor lastPos = priorBlockClicked.getPiece().getLastPosOf(blockClicked);//posição pós-ataque
                    game.externalMove(priorBlockClicked, game.getTable().getBlock(lastPos));
                    game.internalMove(priorBlockClicked, game.getTable().getBlock(lastPos));
                    game.setSheriffBlock(null);
                    game.setClickSequence(true);
                    return TypeClick.last;
                }
            }else{//se a peça atingida morreu
                if(tempPiece.getTpHero() == TypeHero.wizard && tempPiece instanceof Peon) {
                    game.getWizard().setCanMove(true);
                }
                game.removeImage(blockClicked);
                game.externalMove(priorBlockClicked, blockClicked);
                game.internalMove(priorBlockClicked, blockClicked);
                game.setSheriffBlock(null);
                game.setClickSequence(true);
                return TypeClick.last;
            }
        }
        game.setSheriffBlock(null);
        game.setClickSequence(true);
        return TypeClick.last;
    }
}