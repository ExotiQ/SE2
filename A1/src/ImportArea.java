import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ImportArea {
    private AnchorPane anchorPane = new AnchorPane();
    private Button importButton = new Button("Import");
    private Button openfileButton = new Button("Open File");

    public ImportArea(Runnable onOpenFile, Runnable onImport) {
        AnchorPane.setTopAnchor(importButton, 10.0);
        AnchorPane.setRightAnchor(importButton, 200.0);
        AnchorPane.setBottomAnchor(importButton, 10.0);

        AnchorPane.setTopAnchor(openfileButton, 10.0);
        AnchorPane.setRightAnchor(openfileButton, 10.0);
        AnchorPane.setBottomAnchor(openfileButton, 10.0);

        openfileButton.setOnAction(event -> {
            onOpenFile.run();
        });

        importButton.setOnAction(event -> {
            onImport.run();
        });

		/*importButton.setOnAction(event -> {
			onImport.run();
		});

		importButton.setOnAction(event -> {
			onDelete.run();
		});*/

        anchorPane.getChildren().addAll(importButton, openfileButton);
    }

    public Node getPane() {
        return anchorPane;
    }
}
