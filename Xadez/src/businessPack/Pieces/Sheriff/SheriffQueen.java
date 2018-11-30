package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Piece;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;

public class SheriffQueen implements Pistol {
    //atributos>>
    Player player;
    //construtor>>
    public SheriffQueen(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public void recharge(){ }//não possui arma
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){//reação da SheriffQueen
        Piece king;
        try{
            king = table.callForSheriffKing().getPiece();//procura pelo SheriffKing no tabuleiro
        }catch(NullPointerException e){//o SheriffKing está morto
            System.out.println("vc matou meu marido...");
            return false;
        }
        king.reaction(table, enemyBlock);//SheriffKing, proteja-me!
        return false;
    }
}