package pl.edu.pwr.ztw.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.models.Author;
import pl.edu.pwr.ztw.books.models.AuthorBookAssignRequest;
import pl.edu.pwr.ztw.books.models.Book;
import pl.edu.pwr.ztw.books.models.IBooksService;

@RestController
public class BooksController {

    @Autowired
    IBooksService booksService;

    @RequestMapping(value = "/get/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable("id") int id){
        return new ResponseEntity<>(booksService.getBook(id), HttpStatus.OK);
    }

    @PostMapping("/books")
    public Book newBook(@RequestBody Book newBook) {
        return booksService.addBook(newBook);
    }

    @PostMapping("/books/update")
    public Book updateBook(@RequestBody Book newBook)
    {
        return booksService.updateBook(newBook);
    }

    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") int id)
    {
        return booksService.deleteBook(id);
    }

    @PostMapping("/books/assignAuthor/")
        public Book assignAuthorToBook(@RequestBody AuthorBookAssignRequest assignRequest)
        {
            int bookId = assignRequest.getBookId();
            int authorId = assignRequest.getAuthorId();
            return booksService.assignAuthorToBook(bookId, authorId);
        }
    }





