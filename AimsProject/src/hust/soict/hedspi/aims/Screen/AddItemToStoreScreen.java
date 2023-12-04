package hust.soict.hedspi.aims.Screen;


import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JFrame {
    protected Container cp;
    Store store;

    public AddItemToStoreScreen(Store store){
        this.store = store;

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AddItem");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }

    JMenu createMenuBar(){
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
        return menu;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        return center;
    }
    protected class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String a = evt.getActionCommand();
            if(a.equals("Add Book")){
                dispose();
                new AddBookToStoreScreen(store);
            } else if(a.equals("Add CD")) {
                dispose();
                new AddCompactDiscToStoreScreen(store);
            } else if (a.equals("Add DVD")){
                dispose();
                new AddDigitalVideoDiscToStoreScreen(store);
            } else if (a.equals("View store")) {
                dispose();
                new StoreManagerScreen(store);
            }
        }
    }
}
