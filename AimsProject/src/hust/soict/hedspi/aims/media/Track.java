package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private float length;

//    Constructor

    public Track(String title, float length) {
        this.title = title;
        this.length = length;
    }

    //    getter
    public String getTitle() {
        return title;
    }

    public float getLength() {
        return length;
    }

    @Override
    public void Play(){
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
