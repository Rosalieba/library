package com.books.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {

    //region members
    @Autowired
    private BookService bookService;
    //endregion

    //region endpoints
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void createBook(@RequestBody AddBookRequest request) {
        this.bookService.createBook(request.title(), request.authorIds(), request.summary(), request.publicationDate(),
                request.readerCategory(), request.bookCategory(), request.isbn(), request.subjectIds());
    }
    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer id) {
        this.bookService.deleteBook(id);
    }
    //endregion

    //region record
    public record AddBookRequest(String title, List<Integer> authorIds, String summary, Date publicationDate,
                                 String readerCategory, String bookCategory, String isbn, List<Integer> subjectIds){};
    //endregion
}
