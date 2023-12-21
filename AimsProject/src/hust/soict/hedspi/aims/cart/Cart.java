package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hust.soict.hedspi.aims.store.Store.itemInStore;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private static List<Media> itemOrdered = new ArrayList<>();

    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

//    getter
    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

//    method
    public static void addMedia(Media media){
        if (itemOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            itemOrdered.add(media);
            System.out.println("The media has been add");
        }
    }

    public void addMedia(Media[] dvlist){
        if (itemOrdered.size() + dvlist.length > MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            itemOrdered.addAll(Arrays.asList(dvlist));
            System.out.println("The dvlist has been add");
        }
    }
    public void addMedia(Media md1, Media md2){
        if (itemOrdered.size() + 2 > MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            itemOrdered.add(md1);
            itemOrdered.add(md2);
            System.out.println("Two media has been add");
        }
    }
    public static void removeMedia(Media media){
        if (itemOrdered.contains(media)){
            itemOrdered.remove(media);
            System.out.println("Media has been removed form cart.");
        }
        else{
            System.out.println("Can not remove media(not match).");
        }
    }

    public static float totalCost(){
        float total = 0;
        for (Media media : itemOrdered){
            total += media.getCost();
        }
        return total;
    }

    public static void print(){
        int i = 1;
        System.out.println("*****************************CART*****************************");
        System.out.println("Ordered item:");
        for (Media media : itemOrdered){
            System.out.println( i + "." + media.toString());
            i++;
        }
        System.out.println("Total cost : " + Cart.totalCost());
        System.out.println("**************************************************************");
    }

    public static void SearchByID(int id){
        boolean i = false;
        for (Media media : itemOrdered){
            if(media.getId() == id){
                System.out.println(media.toString());
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }

    public static void SearchByTitle(String title){
        boolean i = false;
        for (Media media : itemOrdered){
            if(media.getTitle().equals(title)){
                System.out.println(media.toString());
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }

    public static void AddByTitle(String title){
        boolean i =false;
        for (Media media : itemInStore){
            if(media.getTitle().equals(title)){
                Cart.addMedia(media);
                System.out.println("Added media to cart");
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }
    public static void RemoveByTitle(String title){
        boolean i =false;
        for (Media media : itemOrdered){
            if(media.getTitle().equals(title)){
                Cart.removeMedia(media);
                System.out.println("Media has been removed form cart");
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }

    public static void SortByTitle(){
        itemOrdered.sort(Media.COMPARE_BY_TITLE);
    }

    public static void SortByCost(){
        itemOrdered.sort(Media.COMPARE_BY_COST);
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public void placeOrder(Cart cart) {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("The cart is empty. Cannot place order.");
        } else {
            System.out.println("Order placed successfully.");
            cart.emptyCart();
        }
    }

    public static void PlayMedia(String title){
        boolean i =false;
        for (Media media : itemOrdered){
            if(media.getTitle().equals(title)){
                System.out.println("Playing " + title);;
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }

}
