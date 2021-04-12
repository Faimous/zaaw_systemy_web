package pl.edu.pwr.ztw.books.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BooksService  implements IBooksService{
    private static List<Book> booksRepo = new ArrayList<>();

    static {
        booksRepo.add(new Book(1,"Potop", null, 936));
        booksRepo.add(new Book(2,"Wesele", null, 150));
        booksRepo.add(new Book(3,"Dziady", null, 292));
    }


    public static boolean deleteBook(Book book)
    {
        return booksRepo.remove(book);
    }

    @Override
    public Collection<Book> getBooks() {
        return booksRepo;
    }



    @Override
    public Book addBook(Book book) {
        booksRepo.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        Book bookToUpdate = getBook(book.getId());
        bookToUpdate.setPages(book.getPages());
        bookToUpdate.setTitle(book.getTitle());
        return  bookToUpdate;
    }

    @Override
    public Book getBook(int id) {
        return booksRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public String deleteBook(int id) {
        Book book =getBook(id);
        if(book != null)
        {
            booksRepo.remove(book);
        }
        return "Sucessfully deleted book id:" + id;
    }

    @Override
    public Book assignAuthorToBook(int bookId, int authorId) {
        Book book = getBook(bookId);
        AuthorsService authorsService = new AuthorsService();
        Author author = authorsService.getAuthor(authorId);
        book.author = author;
        return  book;
    }
}
