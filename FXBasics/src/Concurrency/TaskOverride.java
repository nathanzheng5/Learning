package Concurrency;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class TaskOverride extends Application {

    static Task<Integer> task = new Task<Integer>() {
        @Override
        protected Integer call() throws Exception {
            int iterations = 0;
            for (iterations = 0; iterations < 100; iterations++) {
                if (isCancelled()) {
                    break;
                }
                System.out.println("Iteration " + iterations);
            }
            return iterations;
        }

        @Override
        protected void succeeded() {
            // this is called on the JavaFX application thread
            super.succeeded();
            // updateMessage can be called inside call(), and will be run later
            updateMessage("Done!");
        }

        @Override
        protected void cancelled() {
            // this is called on the JavaFX application thread
            super.cancelled();
            updateMessage("Cancelled!");
        }

        @Override
        protected void failed() {
            // this is called on the JavaFX application thread
            super.failed();
            updateMessage("Failed!");
        }
    };

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Thread(task).start();
        System.out.println(task.getMessage());
    }
}
