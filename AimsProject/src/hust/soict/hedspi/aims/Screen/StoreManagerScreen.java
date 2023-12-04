package hust.soict.hedspi.aims.Screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagerScreen extends JFrame{
    private static Store store;

    private Container cp;

    public static Store getStore() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout (new BoxLayout (north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(new TFInputListener());
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new TFInputListener());
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new TFInputListener());
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new TFInputListener());

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout (header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 50));
        title.setForeground (Color.CYAN);

        header.add(Box.createRigidArea (new Dimension (10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension (10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String a = evt.getActionCommand();
            if (a.equals("Add Book")) {
                dispose();
                new AddBookToStoreScreen(StoreManagerScreen.getStore());
            } else if (a.equals("Add CD")) {
                dispose();
                new AddCompactDiscToStoreScreen(StoreManagerScreen.getStore());
            } else if (a.equals("Add DVD")) {
                dispose();
                new AddDigitalVideoDiscToStoreScreen(StoreManagerScreen.getStore());
            } else if (a.equals("View store")) {
            } else if (a.equals("Play")) {
                InformationDialog dialog = new InformationDialog((JFrame) cp, "This is an information message.");
                dialog.setVisible(true);
            }
        }
    }

    private class InformationDialog extends JDialog {
        public InformationDialog(JFrame parent, String message) {
            super(parent, "Information", true);
            setLayout(new BorderLayout());
            JLabel label = new JLabel(message);
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label, BorderLayout.CENTER);

            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            add(okButton, BorderLayout.SOUTH);

            setSize(300, 150);
            setLocationRelativeTo(parent);
        }
    }
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
//        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's Stone(2001)", "Movie",3.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secret(2002)", "Movie", 3.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Hary Potter and the Prisoner of Azkaban(2004)", "Movie", 5.0f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire(2005)", "Movie", 4.5f);
        CompactDisc cd5 = new CompactDisc("Fetch the Bolt Cutter", "CD", 10.39f);
        CompactDisc cd6 = new CompactDisc("Future Nostalgia", "CD", 9.6f);
        Book book7 = new Book("The Hunger Game", "Book", 5.5f);
        Book book8 = new Book("Catching Fire", "Book", 4.9f);
        Book book9 = new Book("Mockingjay", "Book", 5.1f);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(cd5);
        store.addMedia(cd6);
        store.addMedia(book7);
        store.addMedia(book8);
        store.addMedia(book9);

        new StoreManagerScreen(store);
    }
}

