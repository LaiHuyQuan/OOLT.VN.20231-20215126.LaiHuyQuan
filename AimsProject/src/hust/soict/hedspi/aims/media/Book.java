package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    public ArrayList<String> authorList = new ArrayList<>();

//    Constructor
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title) {
        super(title);
    }

//      Method
    public void addAuthors(String author){
        if(this.authorList.contains(author)){
            System.out.println("Author was already added before.");
        }
        else{
            this.authorList.add(author);
            System.out.println("Author has been added.");
        }
    }

    public void removeAuthors(String author){
        if (this.authorList.contains(author)){
            this.authorList.remove(author);
            System.out.println("Author has been removed.");
        }
        else{
            System.out.println("Author can not be removed(not match).");
        }
    }

    @Override
    public String toString() {
        return "Book -" + this.getTitle() + " " + this.getCategory() + ": " + this.getCost() + "$";
    }

}
