package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;
public class Store {

    public ArrayList<DigitalVideoDisc> itemInStore = new ArrayList<>();

    public void addDVD(DigitalVideoDisc disc){
        if (itemInStore.contains(disc)){
            System.out.println("DVD available in store");
        }
        else{
            itemInStore.add(disc);
        }
    }

    public void removeDVD(DigitalVideoDisc disc){
        if(itemInStore.contains(disc)){
            itemInStore.remove(disc);
            System.out.println("DVD has been removed");
        }
        else{
            System.out.println("DVD does not exist");
        }
    }

    @Override
    public boolean equals(DigitalVideoDisc disc) {
        if (disc.getId() == other.) {
            return true;
        }

    }
}
