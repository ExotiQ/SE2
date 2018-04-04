import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EntryArea {

    private final AnchorPane anchorPane = new AnchorPane();
    private final javafx.scene.control.Button searchButton = new Button("Search");

    public EntryArea() {

    }

    public Node getPane() {
        return anchorPane;
    }
}
