public class Media {
    public String title;
    public int id;

    public String category;
    public  float cost;

    //CONSTRUCTOR
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    //GETTER
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }
    
}
