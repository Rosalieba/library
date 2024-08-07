package com.books.library.book;

import com.books.library.author.Author;
import com.books.library.author.AuthorRepository;
import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

@Service
public class BookService {

    //region members
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    Book book = new Book();
    //endregion

    //region CRUD methods
    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public void createBook(String title, List<Integer> authorIds, String summary, Date publicationDate,
                           String readerCategory, String bookCategory, String isbn, List<Integer> subjectIds) {
        book.setTitle(title);
        for (Integer authorId:authorIds) {
            Author author = authorRepository.findById(authorId).orElse(null);
            if (author != null){
                book.getAuthors().add(author);
            } else {
                //exception handling
            }
        }
        book.setSummary(summary);
        book.setPublicationDate(publicationDate);
        book.setReaderCategory(readerCategory);
        book.setBookCategory(bookCategory);
        book.setIsbn(isbn);
        for (Integer subjectId:subjectIds) {
            Subject subject = subjectRepository.findById(subjectId).orElse(null);
            if (subject != null){
                book.getSubjects().add(subject);
            } else {
                //exception handling
            }
        }
       this.bookRepository.save(book);
    }

    public void patchBook(Integer id, String title, List<Integer> authorIds, String summary ){
        Book existingBook = bookRepository.findById(id).orElse(null);
        Set<Author> authors = new HashSet<>();

        if (existingBook != null) {
            if (title != null) {
                existingBook.setTitle(title);
            }
            if (authorIds != null) {
                for (Integer authorId:authorIds) {
                    Author author = authorRepository.findById(authorId).orElse(null);
                    if (author != null) {
                        authors.add(author);
                    } else {
                        //exception handling
                    }
                }
                existingBook.setAuthors(authors);
            }
            if (summary != null) {
                existingBook.setSummary(summary);
            }
            this.bookRepository.save(existingBook);

        }
        /*Function<String, String> testFunction = (input) -> {
            return input + " X";

        };
        testFunction.apply("Hello ");*/
    }

    public void deleteBook(Integer id) {
        this.bookRepository.deleteById(id);
    }
    //endregion
}
