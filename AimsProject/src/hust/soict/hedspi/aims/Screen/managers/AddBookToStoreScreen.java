package hust.soict.hedspi.aims.Screen.managers;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    private TextField idInput;
    private TextField titleInput;
    private TextField catInput;
    private TextField costInput;

    // Constructor
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 2, 2));

        idInput = new TextField(10);
        titleInput = new TextField(10);
        catInput = new TextField(10);
        costInput = new TextField(10);
        center.add(new Label("Enter an Id: "));
        center.add(idInput);
        center.add(new Label("Enter an Title: "));
        center.add(titleInput);
        center.add(new Label("Enter an cat: "));
        center.add(catInput);
        center.add(new Label("Enter an cost: "));
        center.add(costInput);

        JButton addBook = new JButton("Add");
        addBook.addActionListener(new AddBookTFInputListener());
        center.add(addBook);

        return center;
    }

    protected class AddBookTFInputListener extends TFInputListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            Book book = new Book(Integer.parseInt(idInput.getText()), titleInput.getText(), catInput.getText(), Float.parseFloat(costInput.getText()));
            Store.addMedia(book);

            super.actionPerformed(evt);
        }
    }
}
