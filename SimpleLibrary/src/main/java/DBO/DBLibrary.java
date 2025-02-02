package DBO;

import entities.AbsBooks;

import java.util.Set;
import java.util.TreeSet;

public class DBLibrary {

    private Set<AbsBooks> absBooks = new TreeSet<AbsBooks>();

    public <T extends AbsBooks> void increase(T absBooks) {
        this.absBooks.add(absBooks);
    }

}
