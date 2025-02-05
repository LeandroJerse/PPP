package interfaces;

import entities.Book;
import entities.Library;
import entities.Magazine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceMagazine{



    private JLabel JLMagazine;
    private JPanel JPMagazine;
    private JLabel JLTitle;
    private JLabel JLOrg;
    private JLabel JLVol;
    private JLabel JLNro;
    private JLabel JLYear;
    private JTextField JTVol;
    private JTextField JTNro;
    private JTextField JTYear;
    private JTextField JTtitleMg;
    private JTextField JTOrg;
    private JButton JBIncludeMg;
    private JButton JBBooks;
    private JButton JBListing;

    public InterfaceMagazine(Library library) {

        JFrame frameMagazine = new JFrame("Livros");
        frameMagazine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMagazine.setSize(1000, 200);

        JBIncludeMg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Magazine newMagazine = new Magazine(JTtitleMg.getText(), Integer.parseInt(JTYear.getText()) , JTOrg.getText() ,Float.parseFloat(JTVol.getText()), Integer.parseInt(JTNro.getText()) );
                    if(library.containsMagazine(newMagazine)){
                        throw new IllegalArgumentException();
                    };
                    library.addMagazine(newMagazine);
                    JOptionPane.showMessageDialog(frameMagazine, "Revista adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null, "Há valores não preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);

                }
                catch (IllegalArgumentException exe){
                    JOptionPane.showMessageDialog(null, "Livro já existente", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        frameMagazine.getContentPane().add( JPMagazine);
        frameMagazine.setVisible(true);
        JBBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceBooks(library);
                frameMagazine.dispose();
            }
        });
        JBListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceListing(library);
                frameMagazine.dispose();
            }
        });
    }
}
