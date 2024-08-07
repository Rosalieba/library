package com.books.library.subject;

import com.books.library.author.Author;
import com.books.library.author.AuthorRepository;
import com.books.library.book.Book;
import com.books.library.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService {

    //region members
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    //endregion

    //region CRUD methods
    public List<Subject> getSubjects() {
        return this.subjectRepository.findAll();
    }

    public void createSubject(String subjectName, List<Integer> bookIds, List<Integer> authorIds) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        for (Integer bookId:bookIds) {
            Book book = bookRepository.findById(bookId).orElse(null);
            if (book != null) {
                subject.getBooks().add(book);
            } else {
                //TODO exception handling
            }
        }
        for (Integer authorId:authorIds) {
            Author author = authorRepository.findById(authorId).orElse(null);
            if (author != null) {
                subject.getAuthors().add(author);
            } else {
                //TODO exception handling
            }
        }
        this.subjectRepository.save(subject);
    }

    public void patchSubject(Integer id, String subjectName, List<Integer> bookIds, List<Integer> authorIds) {
        Subject existingSubject = subjectRepository.findById(id).orElse(null);
        Set<Book> books = new HashSet<>();
        Set<Author> authors = new HashSet<>();

        if (existingSubject != null) {
            if (subjectName != null) {
                existingSubject.setSubjectName(subjectName);
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
                existingSubject.setBooks(books);
            }
            if (authorIds != null) {
                for (Integer authorId:authorIds) {
                    Author author = authorRepository.findById(authorId).orElse(null);
                    if (author != null) {
                        authors.add(author);
                    } else {
                        //TODO exception handling
                    }
                }
                existingSubject.setAuthors(authors);
            }
            this.subjectRepository.save(existingSubject);
        }


    }

    public void deleteSubject(Integer id) {
        this.subjectRepository.deleteById(id);
    }
    //endregion

}
