package pl.edu.pwr.ztw.books.models;

import java.util.Collection;

public interface IBooksService {
    public Book addBook(Book book);
    public Book updateBook(Book book);
    public Book getBook(int id);
    public String deleteBook(int id);
    public Collection<Book> getBooks();
    public Book assignAuthorToBook(int bookId, int AuthorId);
}
