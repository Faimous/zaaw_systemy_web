package pl.edu.pwr.ztw.books.models;

public class Book {
    private int id;
    private String title;
    int pages;
    Author author;

    public Book(int id, String title, Author author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
    public Author getAuthor() {
        return author;
    }

}
