import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	
	TelefonBook tbook1 = new TelefonBook(FileSystem.path);
	TelefonBook tbook2 = new TelefonBook(null);

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		BorderPane telefonBook1 = createArea(tbook1, true);
		BorderPane telefonBook2 = createArea(tbook2,false);
		root.setLeft(telefonBook1);
		root.setRight(telefonBook2);

		primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

	private BorderPane createArea(TelefonBook tbook, boolean ownTelBook) {
		BorderPane root = new BorderPane();

		EntryArea entryArea = new EntryArea(tbook.getFilteredEntries());
		SearchArea searchArea = new SearchArea();

		searchArea.getTextField().textProperty().addListener((e) -> {
			entryArea.clearSelection();
			String search = searchArea.getTextField().getText();
			tbook.search(search);
		});

		root.setTop(searchArea.getPane());
		if(ownTelBook)	{root.setBottom(createAddDeleteArea(tbook, entryArea).getPane());
		} else	{root.setBottom(createImportArea(tbook, entryArea).getPane());}

		root.setCenter(entryArea.getPane());
		return root;
	}

	private AddDeleteArea createAddDeleteArea(TelefonBook tbook, EntryArea entryArea) {
		return new AddDeleteArea(
                    () -> {
                        tbook.getNumbers().add(new TelefonEntry());
                    },
                    () -> {
                        TelefonEntry selection = entryArea.getSelectedEntry();
                        if (tbook.getNumbers().contains(selection)) {
                            tbook.getNumbers().remove(selection);
                        }
                    });
	}

	private ImportArea createImportArea(TelefonBook tbook, EntryArea entryArea) {
		return new ImportArea(
				() -> {
					Stage fileChooserStage = new Stage();
					fileChooserStage.setTitle("Choose PhoneBook");
					FileChooser fileChooser = new FileChooser();
					File file = fileChooser.showOpenDialog(fileChooserStage);
					if (file != null) {
						tbook2.read(Paths.get(file.getPath()));
					}
				},
				() -> {
					List<TelefonEntry> Selected = entryArea.getSelectedEntries();
					for(TelefonEntry Tel : Selected)	{
						tbook1.add(Tel);
					}
				});
	}

	public void stop() {
		FileSystem.writeFile(tbook1.getNumbers());
	}

    public static void main(String[] args) {
        launch(args);
    }

}