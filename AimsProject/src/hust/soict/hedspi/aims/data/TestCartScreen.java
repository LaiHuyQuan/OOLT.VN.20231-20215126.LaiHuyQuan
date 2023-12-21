package hust.soict.hedspi.aims.data;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.Screen.customers.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestCartScreen extends Application {
    private static Cart cart;
//    private static final Store store = new Store();

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "../../../../aims/Screen/customers/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController cartController = new CartController(cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladin","Animation", "George Lucas", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3", "Animation", 18.99f);

        CompactDisc cd1 = new CompactDisc("cd1", "anime",12.3f);
        CompactDisc cd2 = new CompactDisc("cd2", "anima", 16f);

        Book book1 = new Book("book1", "truyen",12f);
        Book book2 = new Book("Giai tich 2", "khong biet", 120f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(book1);
        store.addMedia(book2);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(book1);
        cart.addMedia(book2);
        launch(args);
    }
}