package entities;

public class Book extends AbsBooks{

    private String author;

    public Book() {
    }

    public Book(String title, Integer Year, String author) {
        super(title, Year);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return this.getTitle() +  "\t" + this.getAuthor() + "\t" + this.getYear();
    }
}
