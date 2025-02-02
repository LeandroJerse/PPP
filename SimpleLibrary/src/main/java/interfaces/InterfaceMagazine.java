package interfaces;

import entities.Book;
import entities.Library;
import entities.Magazine;

import javax.swing.*;
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
        JBIncludeMg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library.addMagazine(new Magazine(JTtitleMg.getText(), Integer.parseInt(JTYear.getText()) , JTOrg.getText() ,Float.parseFloat(JTVol.getText()), Integer.parseInt(JTNro.getText()) ));
            }
        });
    }
}
