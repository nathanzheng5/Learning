import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertConfirmBoxesMain extends Application {

    Stage window;
    Button alertBoxButton;
    Button confirmBoxButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Main window");

        alertBoxButton = new Button("Alert Box");
        alertBoxButton.setOnAction(e -> AlertBox.display("Alert box title", "This is an alert box!"));

        confirmBoxButton = new Button("Confirm Box");
        confirmBoxButton.setOnAction(e -> {
            boolean confirmed = ConfirmBox.display("Confirm Box title", "Are you sure you want to proceed?");
            if (confirmed) {
                System.out.println("confirmed!");
            } else {
                System.out.println("cancelled...");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(alertBoxButton, confirmBoxButton);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
