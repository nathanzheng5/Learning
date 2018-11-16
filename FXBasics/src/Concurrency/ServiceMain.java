package Concurrency;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ServiceMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FirstLineService service = new FirstLineService();
        service.setUrl("https://www.suntailoringvancouver.com");
        service.setOnSucceeded(event -> {
            // this gets called in the JavaFX application thread
            System.out.println("done: " + event.getSource().getValue());
        });
        service.start();
    }

    private static class FirstLineService extends Service<String> {
        private StringProperty url = new SimpleStringProperty();

        public String getUrl() {
            return url.get();
        }

        public StringProperty urlProperty() {
            return url;
        }

        public void setUrl(String url) {
            this.url.set(url);
        }

        @Override
        protected Task<String> createTask() {
            final String _url = getUrl();
            return new Task<String>() {

                // this gets called in a new thread
                @Override
                protected String call() throws Exception {
                    String result = null;
                    BufferedReader in = null;
                    try {
                        URL u = new URL(_url);
                        in = new BufferedReader(new InputStreamReader(u.openStream()));
                        result = in.readLine();
                    } finally {
                        if (in != null) {
                            in.close();
                        }
                    }
                    return result;
                }
            };
        }

    }
}
