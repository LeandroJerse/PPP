package interfaces;

import entities.Book;
import entities.Library;
import entities.Magazine;

import javax.swing.*;
import java.awt.*;
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

                try{
                    Book newBook = new Book("Livro: " + JTTitle.getText(),Integer.parseInt(JTYear.getText()), JTAuthor.getText());
                    if(library.containsBook(newBook)){
                        throw new IllegalArgumentException();
                    };
                    library.addBook(newBook);
                    JOptionPane.showMessageDialog(frameBook, "Livro adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Há valores não preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException exe){
                    JOptionPane.showMessageDialog(null, "Livro já existente", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        frameBook.getContentPane().add( JPBook);
        frameBook.setVisible(true);

        JBMagazine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceMagazine(library);
                frameBook.dispose();
            }
        });


        JBListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceListing(library);
                frameBook.dispose();
            }
        });
    };
    }


