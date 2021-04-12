package pl.edu.pwr.ztw.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.models.Author;
import pl.edu.pwr.ztw.books.models.IAuthorsService;

@RestController
public class AuthorsController {

    @Autowired
    IAuthorsService authorsService;

    @RequestMapping(value = "/get/authors", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthors(){
        return new ResponseEntity<>(authorsService.getAuthors(), HttpStatus.OK);
    }

    @PostMapping("/authors")
    public Author newAuthor(@RequestBody Author newAuthor) {
        return authorsService.addAuthor(newAuthor);
    }

    @RequestMapping(value = "/get/author/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id){
        return new ResponseEntity<>(authorsService.getAuthor(id), HttpStatus.OK);
    }

    @PostMapping("/authors/update")
    public Author updateAuthor(@RequestBody Author newAuthor)
    {
        return authorsService.updateAuthor(newAuthor);
    }

    @PostMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable("id") int id)
    {
        return authorsService.deleteAuthor(id);
    }





}

