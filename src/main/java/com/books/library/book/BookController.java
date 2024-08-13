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
    //endregion members

    //region endpoints
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @PostMapping
    public void createBook(@RequestBody AddBookRequest request) {
        this.bookService.createBook(request.title(), request.authorIds(), request.teaser(), request.summary(), request.publicationDate(),
                request.readerCategory(), request.bookCategory(), request.isbn(), request.subjectIds(), request.isStillInLibrary(),
                request.isBorrowed(), request.borrowerName(), request.language());
    }
    @PatchMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Integer id, @RequestBody PatchBookRequest request) {
        this.bookService.patchBook(id, request.title(), request.authorIds(), request.teaser(), request.summary(),
                request.publicationDate(), request.readerCategory(), request.bookCategory(), request.isbn(), request.subjectIds(), request.isStillInLibrary(),
                request.isBorrowed(), request.borrowerName(), request.language());
    }
    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer id) {
        this.bookService.deleteBook(id);
    }
    //endregion endpoints

    //region records
    public record AddBookRequest(String title, List<Integer> authorIds, String teaser, String summary, Date publicationDate,
                                 String readerCategory, String bookCategory, String isbn, List<Integer> subjectIds, Boolean isStillInLibrary, Boolean isBorrowed, String borrowerName, String language){};

    public record PatchBookRequest(String title, List<Integer> authorIds, String teaser, String summary, Date publicationDate,
                                   String readerCategory, String bookCategory, String isbn, List<Integer> subjectIds,
                                   Boolean isStillInLibrary, Boolean isBorrowed, String borrowerName, String language) {};
    //endregion records
}
