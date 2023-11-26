package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static List<Media> itemInStore = new ArrayList<>();

    public static void addMedia(Media media){
        if (itemInStore.contains(media)){
            System.out.println("Media available in store");
        }
        else{
            itemInStore.add(media);
        }
    }

    public static void removeMedia(Media media){
        if(itemInStore.contains(media)){
            itemInStore.remove(media);
            System.out.println("Media has been removed");
        }
        else{
            System.out.println("Media does not exist");
        }
    }

    public static boolean SearchByID(int id){
        boolean i = false;
        for (Media media : itemInStore){
            if(media.getId() == id){
                System.out.println(media.toString());
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
        return i;
    }

    public static void SearchByTitle(String title){
        boolean i = false;
        for (Media media : itemInStore){
            if(media.getTitle().equals(title)){
                System.out.println(media.toString());
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }

    public static void AddToStore(String title){
        boolean i =false;
        for (Media media : itemInStore){
            if(!media.getTitle().equals(title)){
                Store.addMedia(media);
                System.out.println("Added media to store.");
                i = true;
            }
        }
        if (!i){
            System.out.println("Media is already in store.");
        }
    }

    public static void RemoveFromStore(String title){
        boolean i =false;
        for (Media media : itemInStore){
            if(media.getTitle().equals(title)){
                Store.removeMedia(media);
                System.out.println("Removed media form store.");
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }
    public static void PlayMedia(String title){
        boolean i =false;
        for (Media media : itemInStore){
            if(media.getTitle().equals(title)){
                System.out.println("Playing " + title);
                i = true;
            }
        }
        if (!i){
            System.out.println("no matching");
        }
    }

}
