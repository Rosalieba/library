package com.books.library.author;

import com.books.library.book.Book;
import com.books.library.book.BookRepository;
import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import com.books.library.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AuthorService {

    //region members
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    Author author = new Author();
    //endregion

    //region CRUD methods
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void createAuthor(String forename, String surname, List<Integer> bookIds, List<Integer> subjectIds) {

        author.setForename(forename);
        author.setSurname(surname);
        for (Integer bookId:bookIds) {
            Book book = bookRepository.findById(bookId).orElse(null);
            if (book != null) {
                author.getBooks().add(book);
            } else {
                //TODO handling exception
            }
        }
        for (Integer subjectId: subjectIds) {
            Subject subject = subjectRepository.findById(subjectId).orElse(null);
            if (subject != null) {
                author.getSubjects().add(subject);
            } else {
                //TODO handling exception
            }
        }
        this.authorRepository.save(author);
    }

    public void deleteAuthor(Integer id) {
        this.authorRepository.deleteById(id);
    }
    //endregion
}
