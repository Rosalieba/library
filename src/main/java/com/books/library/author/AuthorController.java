package com.books.library.author;

import com.books.library.book.BookController;
import com.books.library.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public void createAuthor(@RequestBody AddAuthorRequest request) {
        this.authorService.createAuthor(request.forename(), request.surname(), request.subjectIds());
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Integer id) {
        this.authorService.deleteAuthor(id);
    }

    public record AddAuthorRequest(String forename, String surname, List<Integer> subjectIds){};
}
