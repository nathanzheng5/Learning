import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidateIInputMain extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("validate input");


        TextField nameInput = new TextField();

        Button button = new Button("Click me");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);

        window.show();
    }

    private boolean isInt(TextField input, String msg) {
        try {
            int age = Integer.parseInt(msg);
            System.out.println("User is " + age);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Error: " + msg + " is not a number");
            return false;
        }
    }
}
