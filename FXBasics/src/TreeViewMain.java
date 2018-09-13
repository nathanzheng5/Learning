import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TreeViewMain extends Application {

    Stage window;
    Scene scene;
    Button button;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tree View");
        button = new Button("Submit");

        TreeItem<String> root, nathan, meng;
        root = new TreeItem<>();
        root.setExpanded(true);     // initially expanded

        nathan = makeBranch("Nathan", root);
        makeBranch("pork", nathan);
        makeBranch("beef", nathan);
        makeBranch("chicken", nathan);

        meng = makeBranch("Meng", root);
        makeBranch("apple", meng);
        makeBranch("orange", meng);
        makeBranch("banana", meng);

        tree = new TreeView<>(root);
        // root is meaningless, just don't show it
        tree.setShowRoot(false);

        tree.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getValue());
            }
        }));

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}
