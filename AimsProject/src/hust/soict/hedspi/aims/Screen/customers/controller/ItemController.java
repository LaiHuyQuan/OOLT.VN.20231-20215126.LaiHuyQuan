package hust.soict.hedspi.aims.Screen.customers.controller;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.Exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import static hust.soict.hedspi.aims.data.TestViewStoreScreen.cart;

public class ItemController {

    @FXML
    private Button btnAddToCart;
    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    private Media currentMedia;


    public ItemController(Cart cart) {

    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getId().equals("btnAddToCart")) {
            // The "Add to Cart" button was pressed
            cart.addMedia(currentMedia);
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getId().equals("btnPlay")) {
            // The "Play" button was pressed
            if (currentMedia instanceof Playable) {
                ((Playable) currentMedia).Play();
            }
        }
    }

    public void setData(Media media) {
        this.currentMedia = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}

