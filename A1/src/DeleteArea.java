import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final javafx.scene.control.Button deleteButton = new Button("Delete");

    public DeleteArea() {
        AnchorPane.setBottomAnchor(deleteButton,10.0);
        AnchorPane.setRightAnchor(deleteButton, 10.0);
        anchorPane.getChildren().addAll(deleteButton);
    }


    public Node getPane() {
        return anchorPane;
    }
}
