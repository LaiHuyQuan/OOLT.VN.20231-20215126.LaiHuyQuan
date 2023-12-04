package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media implements Playable {

    private String director;
    private float length;

//    Getter


    public String getDirector() {
        return director;
    }

    public float getLength() {
        return length;
    }
//  Constructor
    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, float cost, float length, int id) {
        super(title, category, cost);
        this.setId(id);
        this.length = length;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title) {
        super(title);
    }
}
