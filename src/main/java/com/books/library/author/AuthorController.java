package com.books.library.author;

import com.books.library.book.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/author")
public class AuthorController {

    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public void createAuthor(@RequestBody AddAuthorRequest request) {
        this.authorService.createAuthor(request.forename(), request.surname());
    }

    public record AddAuthorRequest(String forename, String surname){};
}
