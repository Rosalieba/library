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

    /**
     * GET ALL SUBJECTS
     * @return subjects
     */
    public List<Subject> getSubjects() {
        return this.subjectRepository.findAll();
    }

    /**
     * CREATE ONE SUBJET
     * @param subjectName
     * @param bookIds
     * @param authorIds
     */

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

    /**
     * UPDATE-PATCH ONE SUBJECT
     * @param id
     * @param subjectName
     * @param bookIds
     * @param authorIds
     */
    public void patchSubject(Integer id, String subjectName, List<Integer> bookIds, List<Integer> authorIds) {
        Subject existingSubject = subjectRepository.findById(id).orElse(null);

        if (existingSubject != null) {
            if (subjectName != null) {
                existingSubject.setSubjectName(subjectName);
            }
            if (bookIds != null) {
                existingSubject.getBooks().clear();
                for (Integer bookId:bookIds) {
                    Book book = bookRepository.findById(bookId).orElse(null);
                    if (book != null) {
                        existingSubject.getBooks().add(book);
                    } else {
                        //TODO exception handling, bad request error
                    }
                }
            }
            if (authorIds != null) {
                existingSubject.getAuthors().clear();
                for (Integer authorId:authorIds) {
                    Author author = authorRepository.findById(authorId).orElse(null);
                    if (author != null) {
                        existingSubject.getAuthors().add(author);
                    } else {
                        //TODO exception handling
                    }
                }
            }
            this.subjectRepository.save(existingSubject);
        }
    }

    /**
     * DELETE ONE SUBJECT
     * @param id
     */
    public void deleteSubject(Integer id) {
        this.subjectRepository.deleteById(id);
    }
    //endregion

}
