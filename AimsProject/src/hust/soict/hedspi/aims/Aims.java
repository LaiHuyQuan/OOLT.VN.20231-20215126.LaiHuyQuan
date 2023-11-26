package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import java.util.Collections;
import java.util.Scanner;

public class Aims {
    private static String mediaTitle;
    public static Scanner scanner = new Scanner(System.in);

    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int choice = scanner.nextInt();
        switch (choice){
            case 1: storeMenu(); break;
            case 2: updateStore(); break;
            case 3: cartMenu(); break;
            case 0: return;
            default:
                System.out.println("Error, choose again!");
                showMenu();
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int storeMenuChoice = scanner.nextInt();
        switch (storeMenuChoice){
            case 0: showMenu(); break;
            case 1:
                System.out.println("Enter media's title: ");
                scanner.nextLine();
                mediaTitle = scanner.nextLine();
                Store.SearchByTitle(mediaTitle);
                mediaDetailsMenu();
                break;
            case 2:
                System.out.println("Enter media's title");
                scanner.nextLine();
                String mediaTitleAdd = scanner.nextLine();
                Cart.AddByTitle(mediaTitleAdd);
                storeMenu();
                break;
            case 3:
                System.out.println("Enter media's title");
                scanner.nextLine();
                String mediaTitlePlay = scanner.nextLine();
                Store.PlayMedia(mediaTitlePlay);
                storeMenu();
                break;
            case 4:
                cartMenu();
                break;
            default:
                System.out.println("Error, choose again!");
                storeMenu();
        }
    }

    public static void updateStore(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add new media.");
        System.out.println("2. Remove media.");
        System.out.println("0. Back");
        System.out.println("---------------------------------");
        System.out.println("Please choose a number 0-1-2");
        int updateStoreChoice = scanner.nextInt();
        switch (updateStoreChoice){
            case 0: showMenu(); break;
            case 1:
                System.out.println("Added media");
                scanner.nextLine();
                String addToStore = scanner.nextLine();
                Store.AddToStore(addToStore);
                updateStore();
                break;
            case 2:
                System.out.println("Removed media");
                scanner.nextLine();
                String removeFromStore = scanner.nextLine();
                Store.RemoveFromStore(removeFromStore);
                updateStore();
                break;
            default:
                System.out.println("Error, choose again!");
                updateStore();
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play(only available for DVD and CD)");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int detailMenuChoice = scanner.nextInt();
        switch (detailMenuChoice){
            case 1:
                Cart.AddByTitle(mediaTitle);
                mediaDetailsMenu();
                break;
            case 2:
                Store.PlayMedia(mediaTitle);
                mediaDetailsMenu();
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Error, choose again!");
                mediaDetailsMenu();
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int cartMenuChoice = scanner.nextInt();
        switch (cartMenuChoice){
            case 1:
                filterMenu();
                break;
            case 2:
                sortMenu();
                break;
            case 3:
                System.out.println("Enter media's title: ");
                scanner.nextLine();
                String removeMediaTitle = scanner.nextLine();
                Cart.RemoveByTitle(removeMediaTitle);
                cartMenu();
                break;
            case 4:
                System.out.println("Enter media's title");
                scanner.nextLine();
                String mediaTitlePlay = scanner.nextLine();
                Cart.PlayMedia(mediaTitlePlay);
                cartMenu();
                break;
            case 5:
                Cart.print();
                cartMenu();
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Error, choose again");
                cartMenu();
        }
    }

    public static void filterMenu(){
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int filterChoice = scanner.nextInt();
        switch (filterChoice){
            case 1:
                System.out.println("Enter media's ID: ");
                int filterID = scanner.nextInt();
                Cart.SearchByID(filterID);
                filterMenu();
                break;
            case 2:
                System.out.println("Enter media's title: ");
                scanner.nextLine();
                String filterTitle = scanner.nextLine();
                Cart.SearchByTitle(filterTitle);
                filterMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                System.out.println("Error, choose again");
                filterMenu();
        }
    }

    public static void sortMenu(){
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int sortChoice = scanner.nextInt();
        switch (sortChoice){
            case 1:
                Cart.SortByTitle();
                sortMenu();
                break;
            case 2:
                Cart.SortByCost();
                sortMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                System.out.println("Error, choose again");
                sortMenu();
        }
    }

    public static void main(String[] args) {
        Store QuanStore = new Store();
        Cart anOrder = new Cart();

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

        showMenu();
    }
}
