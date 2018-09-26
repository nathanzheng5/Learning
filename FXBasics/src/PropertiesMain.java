import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * TODO: CLASS JAVA DOC HERE
 */
public class PropertiesMain extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Properties");

        Person2 nathan = new Person2();
        nathan.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty() " + nathan.firstNameProperty());
            System.out.println("getFirstName() " + nathan.getFirstName());
        });


        // how do you stick a listener on "firstName"?

        button = new Button("Submit");
        button.setOnAction(e -> nathan.setFirstName("Zheng"));

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();
        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue() + ", y: " + y.getValue());

        x.setValue(9);
        System.out.println("x: " + x.getValue() + ", y: " + y.getValue());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

}
