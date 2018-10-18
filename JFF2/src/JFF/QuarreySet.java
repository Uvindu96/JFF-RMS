package JFF;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QuarreySet {

    private final StringProperty name;
    private final StringProperty quaryDeatail;

    public QuarreySet(String name, String quaryDeatail) {
        this.name = new SimpleStringProperty(name);
        this.quaryDeatail = new SimpleStringProperty(quaryDeatail);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getQuaryDeatail() {
        return quaryDeatail.get();
    }

    public StringProperty quaryDeatailProperty() {
        return quaryDeatail;
    }

    public void setQuaryDeatail(String quaryDeatail) {
        this.quaryDeatail.set(quaryDeatail);
    }
}
