package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {

    private String artist;
    private List<Track> tracks = new ArrayList<>();


//  Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, ArrayList<Track> tracks) {
        super(id, title, category, cost, director);
        if(tracks!=null){
            this.tracks = new ArrayList<>(tracks);
        }else {
            this.tracks = new ArrayList<>();
        }
    }

    public CompactDisc(String title, String category, float cost, float length, int id) {
        super(title, category, cost, length, id);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title) {
        super(title);
    }

//    Method
    public void addTrack(Track track){
        if (tracks.contains(track)){
            System.out.println("Track was already added before.");
        }
        else{
            tracks.add(track);
            System.out.println("Track has been added.");
        }
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            System.out.println("Track has been removed.");
            tracks.remove(track);
        }
        else{
            System.out.println("Track can not be removed(not match).");
        }
    }

    public float getLength(){
        float Totallength = 0;
        for (Track track : tracks){
            Totallength += track.getLength();
        }
        return Totallength;
    }

    @Override
    public String toString() {
        return "CD -" + this.getTitle() + " " + this.getCategory() + " " + this.getDirector() + " " + this.getLength() + ": " + this.getCost() + "$";
    }
}
