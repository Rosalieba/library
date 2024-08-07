package com.books.library.author;

import com.books.library.book.Book;
import com.books.library.book.BookRepository;
import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void patchAuthor(Integer id, String forename, String surname, List<Integer> bookIds,
                            List<Integer> subjectIds) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        Set<Book> books = new HashSet<>();
        Set<Subject> subjects = new HashSet<>();
        if (existingAuthor != null) {
            if (forename != null) {
                existingAuthor.setForename(forename);
            }
            if (surname != null) {
                existingAuthor.setSurname(surname);
            }
            if (bookIds != null) {
                for (Integer bookId:bookIds) {
                    Book book = bookRepository.findById(bookId).orElse(null);
                    if (book != null) {
                        books.add(book);
                    } else {
                        //TODO exception handling
                    }
                }
                existingAuthor.setBooks(books);
            }
            if (subjectIds != null) {
                for (Integer subjectId:subjectIds) {
                    Subject subject = subjectRepository.findById(subjectId).orElse(null);
                    if (subject != null) {
                        subjects.add(subject);
                    } else {
                        //TODO exception handling
                    }
                }
                existingAuthor.setSubjects(subjects);
            }
            this.authorRepository.save(existingAuthor);
        }



    }

    public void deleteAuthor(Integer id) {
        this.authorRepository.deleteById(id);
    }
    //endregion
}
