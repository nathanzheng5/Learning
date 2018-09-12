import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxMain extends Application {

    Stage window;
    ComboBox<String> comboBox;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("check box main");

        Button button = new Button("Click me");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Titanic", "Forest Gump", "Terminator");
        comboBox.setPromptText("What's your favorite movie?");

        // combobox can generate its own action
        comboBox.setOnAction(event -> System.out.println("Selected " + comboBox.getValue()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);

        window.show();
    }
}
