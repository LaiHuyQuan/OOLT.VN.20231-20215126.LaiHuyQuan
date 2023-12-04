package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private String title;
    private int id;
    private String category;
    private  float cost;

//  Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
    }

//    Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

//    Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

//    Method
    public static final Comparator<Media> COMPARE_BY_TITLE = new MediaComparatorByTitle();

    public static final Comparator<Media> COMPARE_BY_COST = new MediaComparatorByCost();


}

