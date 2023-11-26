package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class MediaComparatorById implements Comparator<Media> {
    public int Compare(Media media1, Media media2){
        int costComparison = Float.compare(media2.getId(), media1.getId());
        if (costComparison == 0)
            return media1.getTitle().compareTo(media2.getTitle());
        return costComparison;
    }
}
