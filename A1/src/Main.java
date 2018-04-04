import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();

        SearchArea searchArea = new SearchArea();
        root.setTop(searchArea.getPane());

        // EntryArea entryArea = new EntryArea();
        //root.setTop(entryArea.getPane());

        DeleteArea deleteArea = new DeleteArea();
        root.setBottom(deleteArea.getPane());

        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


