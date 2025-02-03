package DBO;

import entities.AbsBooks;




import java.util.Set;
import java.util.TreeSet;



public class DBLibrary {

    private Set<AbsBooks> absBooks = new TreeSet<AbsBooks>();

    public <T extends AbsBooks> void increase(T absBooks) {
        this.absBooks.add(absBooks);
    }

    public Set<AbsBooks> getAbsBooks() {
        return absBooks;
    }

    public void setAbsBooks(Set<AbsBooks> absBooks) {
        this.absBooks = absBooks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (AbsBooks book : absBooks) {
            sb.append(book.toString()).append("<br>");
        }
        return "<html>" + sb.toString() + "</html>";
    }






    }



