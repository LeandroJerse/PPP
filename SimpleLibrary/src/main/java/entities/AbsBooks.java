package entities;

import java.util.Objects;

public abstract class AbsBooks {
    private String title;
    private Integer year;

    public AbsBooks() {}
    public AbsBooks(String title, Integer Year) {
        this.title = title;
        this.year = Year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbsBooks absBooks = (AbsBooks) o;
        return Objects.equals(title, absBooks.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    public abstract String toString();
}
