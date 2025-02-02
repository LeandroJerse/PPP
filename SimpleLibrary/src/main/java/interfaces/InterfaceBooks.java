package interfaces;

import entities.Book;
import entities.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceBooks {
    private JPanel JPBook;
    private JLabel JLBook;
    private JLabel JLTitle;
    private JTextField JTTitle;
    private JLabel JLAuthor;
    private JTextField JTAuthor;
    private JLabel JLYear;
    private JTextField JTYear;
    private JButton JBinclude;
    private JButton JBMagazine;
    private JButton JBListing;

    public InterfaceBooks(Library library) {

        JFrame frameBook = new JFrame("Livros");
        frameBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBook.setSize(600, 400);

        JBinclude.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                library.addBook(new Book(JTTitle.getText(),Integer.parseInt(JTYear.getText()), JTAuthor.getText()));
            }



        });
        frameBook.getContentPane().add( JPBook);
        frameBook.setVisible(true);

    };
    }


