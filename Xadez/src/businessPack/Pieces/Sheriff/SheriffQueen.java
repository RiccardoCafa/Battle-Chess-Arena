package businessPack.Pieces.Sheriff;

import businessPack.Block;
import businessPack.Piece;
import businessPack.Player;
import businessPack.Table;
import extras.Vetor;
import extras.Pistol;
import javafx.scene.image.ImageView;

public class SheriffQueen implements Pistol {
    //atributos>>
    Player player;
    //construtor>>
    public SheriffQueen(Player player){
        this.player = player;
    }
    //metodos>>
    @Override
    public void recharge(){ }
    @Override
    public boolean reaction(Table table, Vetor vetor, Block enemyBlock){
        Piece king;
        try{
            king = table.callForSheriffKing().getPiece();
        }catch(NullPointerException e){
            System.out.println("vc matou meu marido...");
            return false;
        }
        king.reaction(table, enemyBlock);
        return false;
    }
}