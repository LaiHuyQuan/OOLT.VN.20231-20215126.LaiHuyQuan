package hust.soict.hedspi.aims.Display;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StoreDisplay extends JFrame {
    private JLabel[] CIText = new JLabel[10];
    private JLabel[] CICost = new JLabel[10];
    private JButton[] CIbtn = new JButton[10];
    private JPanel[] menuContents = new JPanel[10];
    public StoreDisplay(){
        setTitle("Store");
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel storeMenu = new JPanel(new BorderLayout());
//menuHeading
        JLabel menuHeading = new JLabel("Aims");
        menuHeading.setForeground(Color.green);
//        set font
        Font headingFont = new Font("Arial", Font.BOLD, 40 );
        menuHeading.setFont( headingFont);

        storeMenu.add(menuHeading, BorderLayout.NORTH);

//menuContent
        JPanel menuContent = new JPanel(new GridLayout(3,3));
        addMenuContents(menuContent);

        storeMenu.add(menuContent, BorderLayout.CENTER);

        add(storeMenu);
        setVisible(true);
    }

    void addMenuContents(JPanel menuContent){
        for (int i = 1; i <= 9; i++){
            menuContents[i] = new JPanel(new GridLayout(3,1));
            menuContents[i].setBorder(new LineBorder(Color.black,1));
            CIText[i] = new JLabel("Content " + i);
            menuContents[i].add(CIText[i]);
            CIText[i].setHorizontalAlignment(SwingConstants.CENTER);
            CIText[i].setVerticalAlignment(SwingConstants.CENTER);

            CICost[i] = new JLabel("Cost: " + i +"$");
            menuContents[i].add(CICost[i]);
            CICost[i].setHorizontalAlignment(SwingConstants.CENTER);
            CICost[i].setVerticalAlignment(SwingConstants.CENTER);

            CIbtn[i] = new JButton("Play");
            menuContents[i].add(CIbtn[i]);
            Dimension preferredSize = new Dimension(150, 50);
            CIbtn[i].setPreferredSize(preferredSize);

            menuContent.add(menuContents[i]);
        }
    }

    public static void main(String[] args) {
        new StoreDisplay();
    }
}
