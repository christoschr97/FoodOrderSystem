package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


public class Main extends Application {

    //dont know
    private ToggleGroup group = new ToggleGroup();
    //layouts
    VBox orderRightTop;
    VBox orderRightCenter;
    VBox orderRightBottom;

    //MENU SCENE BUTTONS
    Button order, orderSupplies, receiveSupplies, close, backBtn, printOrders;
    Text txt1;
    Label lbl1;
    TextField txtfld;
    Scene menu, orderScene, orderSuppliesScene, receiveSuppliesScene;

    //ORDER SCENE BUTTONS
    Button previous, next, pay, addToOrder, addIngredient;
    ChoiceBox<Item> cb;
    Spinner spinner;
    Label orderStatus;
    ListView<Ingredient> stockIngredients;
    Order customerOrder;
//    TableView<Ingredient> ingredientTable;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Apothiki.createIngredients();
        Menu.createItems();
        customerOrder = new Order(1);
        receiveSupplies = new Button("Receive Supplies");
        printOrders = new Button("PrintOrders");
        order = new Button("Order");
        orderSupplies = new Button("Order Supplies");
        close = new Button("CLOSE PORGRAM");
        lbl1 = new Label("Welcome to our Food Service System");
        txtfld = new TextField();
        backBtn = new Button("Back");
        previous = new Button("Previous");
        next = new Button("Next");
        cb = new ChoiceBox<Item>(FXCollections.observableArrayList(getMenuItems())); //get the observable list of items
        stockIngredients = new ListView<Ingredient>(FXCollections.observableArrayList(getListIngredients())); //get the observable list of ingredients
        stockIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        stockIngredients.setCellFactory(param -> new RadioListCell());
        spinner = new Spinner(1, 100, 1);
        pay = new Button("PAY");
        orderStatus = new Label("Order Details");
        addToOrder = new Button("ADD");
        addIngredient = new Button("Add Ingredient");
//        ingredientTable = new TableView<>();
//        ingredientTable.setItems(getListIngredients());
//        //ingredient column
//        TableColumn<Ingredient, String> = new TableColumn<>();
//        ingredientTable.getColumns().addAll(IngedientColumn);


        //adding items to the order
        addToOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Item itemSelected = cb.getValue();
                customerOrder.addOrderItem(new OrderItem(Menu.findItem(itemSelected.getId())));
                Label itemName = new Label(itemSelected.getName() + " " + itemSelected.getPrice());
                orderRightCenter.getChildren().add(itemName);
            }
        });
        //creating the order
        pay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                customerOrder.printOrderItems(); //printing the customer order
                System.out.println(customerOrder);
                customerOrder = new Order(0); //adding new order
                orderRightCenter.getChildren().clear(); //cleaaring the layout which contains the orders
                AlertBox.display("Message", "Order Created Successfully");
            }
        });

        addIngredient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Item itemSelected = cb.getValue();

            }
        });

        //handling the action of changing from menu scene to order scene
        order.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(orderScene);
            }
        });

        //handling the action of changing from order scene to menu scenex
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(menu);
            }
        });

        //creating a layout for the menu page
        GridPane centerBPane = new GridPane();
        centerBPane.setAlignment(Pos.CENTER);
        BorderPane layout = new BorderPane(); //border pane for menu scene

        //adding the elements of the layout
        centerBPane.paddingProperty().setValue(new Insets(10, 10, 10, 10));
        centerBPane.add(order, 1, 1);
        centerBPane.add(receiveSupplies, 2, 1);
        centerBPane.add(orderSupplies, 2, 2);
        centerBPane.add(lbl1, 0, 0, 3, 1);
        layout.setCenter(centerBPane);
        layout.setBottom(close);

        //Creating the scene objects
        menu = new Scene(layout, 1024, 800);

        //######################################### ORDER SCENE ########################################
        //adding elements to orderScene //craeting the order scene layout
        BorderPane orderBPane = new BorderPane(); //border pane for order scene

        //top of order scene
        GridPane topOrderScene = new GridPane();
        topOrderScene.add(backBtn, 0, 0);
        GridPane.setMargin(backBtn, new Insets(10, 10, 10, 10));
        orderBPane.setTop(topOrderScene);

        //center of order scene
        GridPane centerOrder = new GridPane();
        centerOrder.setVgap(25);
        centerOrder.setHgap(15);
        centerOrder.add(cb, 0, 0);
        centerOrder.add(spinner, 1, 0);
        centerOrder.add(addToOrder, 2, 0);
        centerOrder.add(stockIngredients, 0, 1);
//        centerOrder.add(ingredientTable, 0, 1);
        centerOrder.add(addIngredient, 1,1);
        centerOrder.setAlignment(Pos.CENTER);
        orderBPane.setCenter(centerOrder);

        //adding Right to orderScene
        //adding elements to orderSuppliesScene
        BorderPane rightOrder = new BorderPane();
        orderRightTop = new VBox();
        orderRightBottom = new VBox();
        orderRightCenter = new VBox();
        rightOrder.setTop(orderRightTop);
        rightOrder.setBottom(orderRightBottom);
        orderRightTop.getChildren().add(orderStatus);
        rightOrder.setCenter(orderRightCenter);
        orderRightBottom.getChildren().add(pay);
        orderRightBottom.setAlignment(Pos.BOTTOM_CENTER);
        orderBPane.setRight(rightOrder);

        //creating the order scene object
        orderScene = new Scene(orderBPane, 1024, 800);
        Ingredient x = new Ingredient("maitanos", 100);
        Item y = new Item(5, "Pitta souvlaki");

        //creating the orderSupplies Scene
        //orderSuppliesScene = new Scene()
        //Setting title to the Stage
        primaryStage.setTitle("SOUVLAKIA SHOP");

        //Adding scene to the stage
        primaryStage.setScene(menu);

        //Displaying the contents of the stage
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Item> getMenuItems() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        HashMap<Integer, Item> menuItems = Menu.getMenu();
        for (Map.Entry<Integer, Item> map : menuItems.entrySet()) {
            items.add(map.getValue());
            System.out.println(map.getValue());
        }
        return items;
    }


    public ObservableList<Ingredient> getListIngredients() {
        ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();
        HashMap<Integer, Ingredient> menuItems = Apothiki.getStock();
        for (Map.Entry<Integer, Ingredient> map : menuItems.entrySet()) {
            ingredients.add(map.getValue());
            System.out.println(map.getValue());
        }
        return ingredients;
    }


    private class RadioListCell extends ListCell<Ingredient> {
        @Override
        public void updateItem(Ingredient obj, boolean empty) {
            super.updateItem(obj, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                RadioButton radioButton = new RadioButton(obj.getName());
                radioButton.setToggleGroup(group);
                // Add Listeners if any
                setGraphic(radioButton);
            }

        }

    }

}//end of class


//



