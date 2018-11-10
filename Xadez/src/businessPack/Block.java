
package businessPack;

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
}
