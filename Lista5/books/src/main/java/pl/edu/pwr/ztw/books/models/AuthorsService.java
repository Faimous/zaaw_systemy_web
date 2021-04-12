package pl.edu.pwr.ztw.books.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorsService implements IAuthorsService {
    private static List<Author> authorsRepo = new ArrayList<>();

    static {
        authorsRepo.add(new Author(1,"Henryk","Sienkiewicz"));
        authorsRepo.add(new Author(2,"Stanisław","Reymont"));
        authorsRepo.add(new Author(3,"Adam","Mickiewicz"));
    }

    @Override
    public Author addAuthor(Author author) {
       authorsRepo.add(author);
       return author;
    }

    @Override
    public Author updateAuthor(Author author) {
        Author authorToUpdate = getAuthor(author.getId());
        authorToUpdate.setName(author.getName());
        authorToUpdate.setLastName(author.getLastName());
        return authorToUpdate;
    }

    public Author getAuthor(int id) {
        return authorsRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public String deleteAuthor(int id) {

        Author author = getAuthor(id);
        if(author != null)
        {
            authorsRepo.remove(author);
        }
        return "Successfully deleted author id:" + id;
    }

    @Override
    public Collection<Author> getAuthors() {
        return authorsRepo;
    }
}

