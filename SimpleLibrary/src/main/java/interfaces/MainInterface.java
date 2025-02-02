package interfaces;

import entities.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface {
    private JPanel JPMainP;
    private JPanel JPTop;
    private JLabel JLMainTitle;
    private JButton JBToBook;
    private JButton JBToMagazine;
    private JButton JBToListing;

    public MainInterface() {

        Library libary = new Library();

        JFrame frame = new JFrame("Interface Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JBToBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new InterfaceBooks(libary);



            }
        });
        frame.getContentPane().add(JPMainP);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MainInterface();

    }


}
