import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClosingProgramMain extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("properly close window");

        window.setOnCloseRequest(event -> {
            // user clicked close, generated close event, but we will consume the event and take care of it.
            event.consume();

            closeProgram();
        });

        button = new Button("Close Program button");
        button.setOnAction(event -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        if (answer) {
            System.out.println("confirmed close");
            window.close();
        } else {
            System.out.println("cancelled close");
        }
    }
}
