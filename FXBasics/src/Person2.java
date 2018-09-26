import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Person class with Property.
 */
public class Person2 {
    private StringProperty firstName = new SimpleStringProperty(
            this, // the object that contains it
            "firstName", // name of the property
            "" // default value
            );

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
