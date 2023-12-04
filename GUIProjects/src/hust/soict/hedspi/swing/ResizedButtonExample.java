package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;

public class ResizedButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Resized Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click me");

        // Đặt kích thước cho nút
        Dimension preferredSize = new Dimension(150, 50);
        button.setPreferredSize(preferredSize);

        button.addActionListener(e -> {
            System.out.println("Button clicked!");
        });

        frame.add(button);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
