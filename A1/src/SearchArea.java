import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchArea {
	private final AnchorPane anchorPane = new AnchorPane();
	private final TextField textField = new TextField();
	
	public SearchArea() {
		AnchorPane.setTopAnchor(textField, 10.0);
		AnchorPane.setLeftAnchor(textField, 10.0);
		AnchorPane.setRightAnchor(textField, 10.0);

		anchorPane.getChildren().addAll(textField);
	}
	
	public Node getPane() {
		return anchorPane;
	}
	
	public TextField getTextField() {
		return this.textField;
	}

}