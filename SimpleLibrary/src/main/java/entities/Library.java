package entities;

import DBO.DBLibrary;

public class Library {

    private DBLibrary dbLibrary = new DBLibrary();

    public void addBook(Book book) {
        dbLibrary.increase(book);
    }
    public void addMagazine(Magazine magazine) {
        dbLibrary.increase(magazine);
    }

    public String toString(){
        return dbLibrary.toString();
    }

    public DBLibrary getDbLibrary() {
        return dbLibrary;
    }

    public boolean containsBook(Book book) {
        return dbLibrary.contains(book);
    }


    public boolean containsMagazine(Magazine newMagazine) {
        return dbLibrary.contains(newMagazine);
    }
}
