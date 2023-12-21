package hust.soict.hedspi.aims.data;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.Screen.customers.controller.CartController;
import hust.soict.hedspi.aims.Screen.customers.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestViewStoreScreen extends Application {
    public static Cart cart;
    private static final Store store = new Store();

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "../aims/Screen/customers/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladin","Animation", "George Lucas", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3", "Animation", 18.99f);

        CompactDisc cd1 = new CompactDisc("cd1", "anime",12.3f);
        CompactDisc cd2 = new CompactDisc("cd2", "anima", 16f);

        Book book1 = new Book("book1", "truyen",12f);
        Book book2 = new Book("Giai tich 2", "khong biet", 120f);
        Store.addMedia(dvd1);
        Store.addMedia(dvd2);
        Store.addMedia(dvd3);

        Store.addMedia(cd1);
        Store.addMedia(cd2);
        Store.addMedia(book1);
        Store.addMedia(book2);
        launch(args);
    }
}