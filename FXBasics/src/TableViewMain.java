import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableViewMain extends Application {

    Stage window;
    Scene scene;
    Button button;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tree View");
        button = new Button("Submit");

        // set up columns
        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));    // this has to be the same as the field name in Product

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setMinWidth(100);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // put columns to table
        table = new TableView<>();
        // set table data
        table.setItems(getProducts());
        table.getColumns().addAll(nameCol, priceCol, quantityCol);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // text fields
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(100);

        // button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        VBox layout = new VBox();
        layout.getChildren().addAll(table, hBox);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    private void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);

        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    private void deleteButtonClicked() {
        ObservableList<Product> allItems = table.getItems();
        ObservableList<Product> selectedItems = table.getSelectionModel().getSelectedItems();
        selectedItems.forEach(allItems::remove);
    }

    public ObservableList<Product> getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.99, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("Toilet", 99.99, 74));
        products.add(new Product("DVD", 19.99, 12));
        products.add(new Product("Corn", 1.49, 846));
        return products;
    }

}
