
package businessPack;

import extras.BlockState;
import extras.Who;
import javafx.scene.image.Image;
import extras.Vetor;

public class Block {
    //atributos>>
    private Piece piece;
    private Vetor vetor;
    private Image image;
    //construtor>>
    public Block(Piece piece, int x, int y) {
        this.piece = piece;
        vetor = new Vetor(x, y);
    }
    //metodos>>
    public boolean isEmpty(){
        return piece == null;
    }
    //getset>>
    public Image getImage(Image image){
        return image;
    }
    public Vetor getVetor(){
        return vetor;
    }
    public Piece getPiece(){
        return piece;
    }
    public BlockState getBlockState(Player playerLooking) {
        if(piece != null) {
            if(playerLooking.getPlayingTurn() == 1) {
                return piece.getPlayer() == Who.player1 ? BlockState.Friend : BlockState.Enemy;
            } else {
                return piece.getPlayer() == Who.player2 ? BlockState.Enemy : BlockState.Friend;
            }
        }
        return BlockState.Empty;
    }
}
