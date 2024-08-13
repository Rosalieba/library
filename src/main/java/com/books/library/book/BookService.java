package com.books.library.book;

import com.books.library.author.Author;
import com.books.library.author.AuthorRepository;
import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * GET ALL BOOKS
     * @return books
     */
    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    /**
     * CREATE ONE BOOK
     * @param title
     * @param authorIds
     * @param summary
     * @param publicationDate
     * @param readerCategory
     * @param bookCategory
     * @param isbn
     * @param subjectIds
     */
    public void createBook(String title, List<Integer> authorIds, String teaser,String summary, Date publicationDate,
                           String readerCategory, String bookCategory, String isbn, List<Integer> subjectIds,
                           Boolean isStillInLibrary, Boolean isBorrowed, String borrowerName, String language) {
        book.setTitle(title);
        for (Integer authorId:authorIds) {
            Author author = authorRepository.findById(authorId).orElse(null);
            if (author != null){
                book.getAuthors().add(author);
            } else {
                //TODO exception handling
            }
        }
        book.setTeaser(teaser);
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
                //TODO exception handling
            }
        }
        book.setStillInLibrary(isStillInLibrary);
        book.setBorrowed(isBorrowed);
        book.setBorrowerName(borrowerName);
        book.setLanguage(language);

       this.bookRepository.save(book);
    }

    /**
     * UPDATE-PATCH ONE BOOK
     * @param id
     * @param title
     * @param authorIds
     * @param summary
     * @param publicationDate
     * @param readerCategory
     * @param bookCategory
     * @param isbn
     * @param subjectIds
     */
    public void patchBook(Integer id, String title, List<Integer> authorIds, String teaser, String summary, Date publicationDate,
                          String readerCategory, String bookCategory, String isbn, List<Integer> subjectIds,
                          Boolean isStillInLibrary, Boolean isBorrowed, String borrowerName, String language){
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            if (title != null) {
                existingBook.setTitle(title);
            }
            if (authorIds != null) {
                existingBook.getAuthors().clear();
                for (Integer authorId:authorIds) {
                    Author author = authorRepository.findById(authorId).orElse(null);
                    if (author != null) {
                        existingBook.getAuthors().add(author);
                    } else {
                        //TODO exception handling
                    }
                }
            }
            if (teaser != null) {
                existingBook.setTeaser(teaser);
            }
            if (summary != null) {
                existingBook.setSummary(summary);
            }
            if (publicationDate != null) {
                existingBook.setPublicationDate(publicationDate);
            }
            if (readerCategory != null) {
                existingBook.setReaderCategory(readerCategory);
            }
            if (bookCategory != null) {
                existingBook.setBookCategory(bookCategory);
            }
            if (isbn != null) {
                existingBook.setIsbn(isbn);
            }
            if (subjectIds != null) {
                existingBook.getSubjects().clear();
                for (Integer subjectId:subjectIds) {
                    Subject subject = subjectRepository.findById(subjectId).orElse(null);
                    if (subject != null) {
                        existingBook.getSubjects().add(subject);
                    } else {
                        //TODO exception handling
                    }
                }
            }
            if (isStillInLibrary != null) {
                existingBook.setStillInLibrary(isStillInLibrary);
            }
            if (isBorrowed != null) {
                existingBook.setBorrowed(isBorrowed);
            }
            if (borrowerName != null) {
                existingBook.setBorrowerName(borrowerName);
            }
            if (language != null) {
                existingBook.setLanguage(language);
            }
            this.bookRepository.save(existingBook);
        }
    }

    /**
     * DELETE ONE BOOK
     * @param id
     */
    public void deleteBook(Integer id) {
        this.bookRepository.deleteById(id);
    }
    //endregion
}
