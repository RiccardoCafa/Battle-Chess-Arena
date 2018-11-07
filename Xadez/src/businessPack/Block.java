
package businessPack;

import javafx.scene.image.Image;
import xadez.Vetor;

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
    public Image getImage(Image image){
        return image;
    }
}
