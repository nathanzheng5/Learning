package Concurrency;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.util.concurrent.ExecutorService;

/**
 * TODO: CLASS JAVA DOC HERE
 */
public class ProgressBarMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label progressText = new Label();
        ProgressBar bar = new ProgressBar();
        Button startButton = new Button("Start");
        Button cancelButton = new Button("Cancel");

        // note that this task can only be used once. Use a service class if you need it to be reusable.
        Task<Void> task = new Task<Void>() {
            static final int max = 100;

            @Override
            protected Void call() throws Exception {
                for (int i = 1; i <= max; i++) {
                    if (isCancelled()) {
                        break;
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        if (isCancelled()) {
                            updateMessage("Cancelled");
                            break;
                        }
                    }

                    updateProgress(i, max);
                    updateMessage(i * 100.0 / max + "%");
                }
                return null;
            }
        };

        bar.progressProperty().bind(task.progressProperty());
        progressText.textProperty().bind(task.messageProperty());
        startButton.setOnAction(e -> new Thread(task).start());
        cancelButton.setOnAction(e -> task.cancel());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(progressText, bar, startButton, cancelButton);
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
