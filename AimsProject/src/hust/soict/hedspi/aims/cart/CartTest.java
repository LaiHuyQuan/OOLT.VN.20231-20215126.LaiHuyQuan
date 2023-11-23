package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setQtyOrdered(0);

        Store store1 = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "George Lucas", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print(cart);

        store1.addDVD(dvd1);
        store1.addDVD(dvd2);
    }
}
