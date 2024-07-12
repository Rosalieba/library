package com.books.library.book;

import com.books.library.author.Author;
import com.books.library.author.AuthorRepository;
import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public void deleteBook(Integer id) {
        this.bookRepository.deleteById(id);
    }
    //endregion
}
