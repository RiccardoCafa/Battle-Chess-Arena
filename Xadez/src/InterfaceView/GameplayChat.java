package InterfaceView;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class GameplayChat extends TextArea {
    
    public void addText(String textToShow) {
        appendText("\n" + textToShow);
    }
    
    public void addText(String textToShow, Color color) {
        
    }
    
}
