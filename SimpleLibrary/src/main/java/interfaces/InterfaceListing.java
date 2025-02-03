package interfaces;

import entities.Library;

import javax.swing.*;

public class InterfaceListing {
    private JLabel JLListing;


    private JPanel JPList;
    private JLabel JLDBLib;

    public InterfaceListing(Library library) {

        JFrame frameList = new JFrame("Listagem");
        JLDBLib.setText(library.toString());

        frameList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameList.setSize(600, 400);

        String[] books = library.toString().split("\n");

        // Cria o JList com os dados
        JList<String> bookList = new JList<>(books);

        JScrollPane scrollPane = new JScrollPane(bookList);



        frameList.getContentPane().add( JPList );
        frameList.setVisible(true);

        }



}





