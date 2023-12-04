package hust.soict.hedspi.aims.Screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private TextField idInput;
    private TextField titleInput;
    private TextField catInput;
    private TextField costInput;
    private TextField directorInput;

    // Constructor
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 2, 2));

        idInput = new TextField(10);
        titleInput = new TextField(10);
        catInput = new TextField(10);
        costInput = new TextField(10);
        directorInput = new TextField(10);

        center.add(new Label("Enter an Id: "));
        center.add(idInput);
        center.add(new Label("Enter a Title: "));
        center.add(titleInput);
        center.add(new Label("Enter a Category: "));
        center.add(catInput);
        center.add(new Label("Enter a Cost: "));
        center.add(costInput);
        center.add(new Label("Enter a Director: "));
        center.add(directorInput);

        JButton addCD = new JButton("Add");
        addCD.addActionListener(new AddCompactDiscTFInputListener());
        center.add(addCD);

        return center;
    }

    protected class AddCompactDiscTFInputListener extends TFInputListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Tạo đối tượng CompactDisc từ các trường đầu vào và thêm vào store
            CompactDisc compactDisc = new CompactDisc(
                    Integer.parseInt(idInput.getText()),
                    titleInput.getText(),
                    catInput.getText(),
                    Float.parseFloat(costInput.getText()),
                    directorInput.getText(),
                    null
            );
            store.addMedia(compactDisc);

            super.actionPerformed(evt);
        }
    }
}
