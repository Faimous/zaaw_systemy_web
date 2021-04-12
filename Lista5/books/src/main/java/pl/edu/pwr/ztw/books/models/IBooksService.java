package pl.edu.pwr.ztw.books.models;

import java.util.Collection;

public interface IBooksService {
    Collection<Book> getBooks();
    Book getBook(int id);
}
