package JFF;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerDB {

    private final StringProperty name;
    private final StringProperty password;


    public CustomerDB(String name,String password) {
        this.name = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(password);

    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
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
}
