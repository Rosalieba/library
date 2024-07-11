package com.books.library.book;

import com.books.library.author.Author;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void createBook(@RequestBody AddBookRequest request) {
        this.bookService.createBook(request.title(), request.summary(),request.authorIds(), request.subjectIds());
    }
    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer id) {
        this.bookService.deleteBook(id);
    }

    /*@PutMapping(path = "{bookId}")
    public void updateBook(
            @PathVariable("bookId") Integer id,
            @RequestBody AddBookRequest request) {
            this.bookService.updateBook(request.title(), request.summary(), request.authorIds(), request.subjectIds);
    }*/

     {

    }
    public record AddBookRequest(String title, String summary, List<Integer> authorIds, List<Integer> subjectIds){};
}
