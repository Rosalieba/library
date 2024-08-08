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

    /**
     * GET ALL AUTHORS
     * @return authors
     */
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    /**
     * CREATE ONE AUTHOR
     * @param forename
     * @param surname
     * @param bookIds
     * @param subjectIds
     */
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

    /**
     * UPDATE-PATCH ONE AUTHOR
     * @param id
     * @param forename
     * @param surname
     * @param bookIds
     * @param subjectIds
     */
    public void patchAuthor(Integer id, String forename, String surname, List<Integer> bookIds,
                            List<Integer> subjectIds) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);

        if (existingAuthor != null) {
            if (forename != null) {
                existingAuthor.setForename(forename);
            }
            if (surname != null) {
                existingAuthor.setSurname(surname);
            }
            if (bookIds != null) {
                existingAuthor.getBooks().clear();
                for (Integer bookId:bookIds) {
                    Book book = bookRepository.findById(bookId).orElse(null);
                    if (book != null) {
                        existingAuthor.getBooks().add(book);
                    } else {
                        //TODO exception handling
                    }
                }
            }
            if (subjectIds != null) {
                existingAuthor.getSubjects().clear();
                for (Integer subjectId:subjectIds) {
                    Subject subject = subjectRepository.findById(subjectId).orElse(null);
                    if (subject != null) {
                        existingAuthor.getSubjects().add(subject);
                    } else {
                        //TODO exception handling
                    }
                }
            }
            this.authorRepository.save(existingAuthor);
        }



    }

    /**
     * DELETE ONE AUTHOR
     * @param id
     */
    public void deleteAuthor(Integer id) {
        this.authorRepository.deleteById(id);
    }
    //endregion
}
