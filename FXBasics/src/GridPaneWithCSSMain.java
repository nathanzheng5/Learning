import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneWithCSSMain extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("my grid pane tutorial");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));    // outside padding
        grid.setVgap(8);                                // between each cell
        grid.setHgap(10);

        Label nameLabel = new Label("User name:");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);
        // inline style
//        nameLabel.setStyle("-fx-text-fill: #e8e8e8");

        TextField nameInput = new TextField("nzheng");
        GridPane.setConstraints(nameInput, 1, 0);

        Label pwLabel = new Label("Password:");
        GridPane.setConstraints(pwLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");    // the gray text as "hint"
        GridPane.setConstraints(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> System.out.println("Logging in!"));

        Button signUpButton = new Button("Sign up");
        signUpButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(signUpButton, 1, 3);

        grid.getChildren().addAll(nameLabel, nameInput, pwLabel, passwordField, loginButton, signUpButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("Viper.css");
        window.setScene(scene);

        window.show();
    }
}
