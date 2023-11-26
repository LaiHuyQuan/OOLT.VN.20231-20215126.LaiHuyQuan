package hust.soict.hedspi.aims.media;

public interface Playable {
    default void Play(){
        System.out.println("Playing...");
    }
}
