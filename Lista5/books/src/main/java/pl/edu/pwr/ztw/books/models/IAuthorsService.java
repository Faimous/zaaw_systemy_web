package pl.edu.pwr.ztw.books.models;

import java.util.Collection;

public interface IAuthorsService {
    public Author addAuthor(Author book);
    public Author updateAuthor(Author book);
    public Author getAuthor(int id);
    public String deleteAuthor(int id);
    public Collection<Author> getAuthors();
}
