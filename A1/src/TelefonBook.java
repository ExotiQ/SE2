import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class TelefonBook {

    private final List<TelefonNumber> telefonNumbers = new ArrayList<>();
    private final ObservableList<TelefonNumber> observableTelefonNumbers = FXCollections.observableArrayList(telefonNumbers);

    TelefonBook()   {
        observableTelefonNumbers.add(new TelefonNumber("Flo","Gesell","12345"));
    }

    public ObservableList<TelefonNumber> getNumbers()  {
        return observableTelefonNumbers;
    }

}
