package businessPack;

import InterfaceView.GameManager;
import businessPack.Heros.Lapa;
import businessPack.Pieces.Tower;
import extras.BlockState;
import extras.Vetor;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class OnBlockClicked implements EventHandler<MouseEvent> {
    GameManager gameManager;
    
    public OnBlockClicked(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    
    @Override
    public void handle(MouseEvent event) {
        
    }
    
}
