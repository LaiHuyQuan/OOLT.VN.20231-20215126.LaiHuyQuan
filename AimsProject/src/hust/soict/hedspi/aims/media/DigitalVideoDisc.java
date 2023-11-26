package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {


    public DigitalVideoDisc(String title, String category, float cost, float length, int id) {
        super(title, category, cost, length, id);
    }

    public DigitalVideoDisc(String title, String category, String director, float length, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "DVD -" + this.getTitle() + " " + this.getCategory() + " " + this.getDirector() + " " + this.getLength() + ": " + this.getCost() + "$";
    }

    @Override
    public void Play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

}

