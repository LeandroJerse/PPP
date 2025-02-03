package entities;

import java.util.Objects;

public abstract class AbsBooks implements Comparable<AbsBooks>{
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

    @Override
    public int compareTo(AbsBooks other) {
        // Primeiro, compara pelo título
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Se os títulos forem iguais, compara pelo ano
        return this.year.compareTo(other.year);
    }



}
