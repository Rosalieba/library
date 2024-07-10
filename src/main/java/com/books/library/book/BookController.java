package com.books.library.book;

import com.books.library.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void createBook(@RequestBody AddBookRequest request) {
        this.bookService.createBook(request.title(), request.summary(),request.authorIds());
    }
    public record AddBookRequest(String title, String summary, List<Integer> authorIds){};
}
