package com.books.library.author;

import com.books.library.book.BookService;
import com.books.library.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/author")
public class AuthorController {

    //region members
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private SubjectService subjectService;
    //endregion

    //region endpoints
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public void createAuthor(@RequestBody AddAuthorRequest request) {
        this.authorService.createAuthor(request.forename(), request.surname(), request.bookIds(), request.subjectIds());
    }

    @PatchMapping(path = "{authorId}")
    public void updateAuthor(@PathVariable("authorId") Integer id, @RequestBody PatchAuthorRequest request) {
        this.authorService.patchAuthor(id, request.forename(), request.surname(), request.bookIds(), request.subjectIds());
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Integer id) {
        this.authorService.deleteAuthor(id);
    }
    //endregion

    //region record classes
    public record AddAuthorRequest(String forename, String surname, List<Integer> bookIds, List<Integer> subjectIds){};

    public record PatchAuthorRequest(String forename, String surname, List<Integer> bookIds,
                                     List<Integer> subjectIds){};
    //endregion
}
