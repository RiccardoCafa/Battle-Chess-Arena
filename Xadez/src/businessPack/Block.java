
package businessPack;
import extras.BlockState;
import extras.Who;
import javafx.scene.image.Image;
import extras.Vetor;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Block extends ImageView {
    //atributos>>
    private Piece piece;
    private Vetor vetor;
    private Image myImg;
    protected final float imageWidth = 65;
    protected final float imageHeight = 65;
    private final Image greenBlock = new Image("InterfaceView/imagens/blocoVerde.png", imageWidth, imageHeight, false, false );
    private final Image redBlock = new Image("InterfaceView/imagens/blocoVermelho.png", imageWidth, imageHeight, false, false );
    //private Image imgBlock;
    //construtor>>
    public Block(Piece piece, int x, int y, int color) { //0-white 1-black
        this.piece = piece;
        vetor = new Vetor(x, y);
        if(color == 0) {
            myImg = new Image("InterfaceView/imagens/blocoBranco.png", imageWidth, imageHeight, false, false);
        } else {
            myImg = new Image("InterfaceView/imagens/blocoPreto.png", imageWidth, imageHeight, false, false);
        }
        this.setImage(myImg);
    }
    //metodos>>
    public boolean isEmpty(){
        return piece == null;
    }
    //getset>>
    public boolean hitPiece(int damage){
        boolean died = false;
        if(piece != null){
            if(!piece.hit(damage)){
                died = true;
                setPiece(null);
            }
        }
        return died;//está morto ou não?
    }
    public Vetor getVetor(){
        return vetor;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece p){
        try{
            piece = p;
        }catch(NullPointerException e){
            piece = null;
        }
    }
    public BlockState getBlockState(Player playerLooking) {
        if(piece != null) {
//            if(piece.vetor.getX() == vetor.getX() && piece.vetor.getY() == vetor.getY()) {
//                return BlockState.ItsMeMario;
//            }
            if(playerLooking.getWho() == Who.player2) {
                return piece.getWho() == Who.player2 ? BlockState.Friend : BlockState.Enemy;
            } else {
                return piece.getWho() == Who.player1 ? BlockState.Friend : BlockState.Enemy;
            }
        }
        return BlockState.Empty;
    }
    public BlockState getBlockState(Player playerLooking, Block newBlock) {
        if(piece != null) {
            Piece p = newBlock.getPiece();
            if(p.vetor.getX() == vetor.getX() && p.vetor.getY() == vetor.getY()) {
                return BlockState.ItsMeMario;
            }
            if(playerLooking.getWho() == Who.player2) {
                return piece.getWho() == Who.player2 ? BlockState.Friend : BlockState.Enemy;
            } else {
                return piece.getWho() == Who.player1 ? BlockState.Friend : BlockState.Enemy;
            }
        }
        return BlockState.Empty;
    }

    /**
     *
     * @param color 0 for green 1 for red
     */
    public void colorChange(int color) { //0-Green 1-red
        //BlockState bs = getBlockState(playerLooking);
        //if(bs == BlockState.Friend) return;
        if(color == 0) {
            this.setImage(greenBlock);
        } else {
            this.setImage(redBlock);
        }
    }
    public void colorDefault() {
        this.setImage(myImg);
    }
}
