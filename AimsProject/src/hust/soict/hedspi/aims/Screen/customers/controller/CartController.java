package hust.soict.hedspi.aims.Screen.customers.controller;

import hust.soict.hedspi.aims.Exception.PlayerException;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class CartController {
    private Cart cart = new Cart();
    private Store store = new Store();

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TextField tfFilter;
    @FXML
    private ObservableList<Media> mediaList = cart.getItemsOrdered();
    private FilteredList<Media> filteredMediaList = new FilteredList<>(cart.getItemsOrdered());

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Button clickedButton = (Button) event.getSource();
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (clickedButton.getId().equals("btnPlay")) {
            if (media instanceof Playable) {
                ((Playable) media).Play();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText("Total cost: " + cart.totalCost() + " $");
    }

    @FXML
    void btnPlaceOrderPresssed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Place Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to place the order?");
        ButtonType buttonType = alert.showAndWait().orElse(ButtonType.CANCEL);
        if (buttonType == ButtonType.OK) {
            cart.placeOrder(cart);
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Place Order Successful");
            info.setHeaderText(null);
            info.setContentText("Your order has been placed successfully!");
            info.showAndWait();
            // Reset the cart
            cart = new Cart();
            try {
                final String STORE_FXML_FILE_PATH = "../view/Store.fxml";
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
                fxmlLoader.setController(new ViewStoreController(store, cart));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Store");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "../view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart != null) {
            mediaList = cart.getItemsOrdered();
            filteredMediaList = new FilteredList<>(mediaList, p -> true);
            tblMedia.setItems(cart.getItemsOrdered());
        } else {
            System.err.println("Cart is null. Check initialization.");
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observableValue, media, newValue) -> updateButtonBar(newValue));
        costLabel.setText("Total cost: " + cart.totalCost() + " $");


        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()) {
                resetFilter();
            } else {
                showFilteredMedia(newValue);
            }
        });

        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(tfFilter.getText()));
        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(tfFilter.getText()));
    }

    private void showFilteredMedia(String filter) {
        filteredMediaList.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = filter.toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });

        tblMedia.setItems(filteredMediaList);
    }

    private void resetFilter() {
        filteredMediaList.setPredicate(media -> true);

        tblMedia.setItems(cart.getItemsOrdered());
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }
}
