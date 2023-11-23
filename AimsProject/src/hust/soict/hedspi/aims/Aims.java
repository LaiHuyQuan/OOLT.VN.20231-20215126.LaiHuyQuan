package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
public class Aims {

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        anOrder.setQtyOrdered(0);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "George Lucas", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3,dvd2);

//        anOrder.removeDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is : ");
        System.out.println(anOrder.totalCost());
        anOrder.showCart(anOrder);

    }
}
