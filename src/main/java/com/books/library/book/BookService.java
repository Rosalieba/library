package com.books.library.book;

import com.books.library.author.Author;
import com.books.library.author.AuthorRepository;
import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    Book book = new Book();


    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public void createBook(String title, String summary, List<Integer> authorIds, List<Integer> subjectIds) {
        //Book book = new Book();
        book.setTitle(title);
        book.setSummary(summary);
        for (Integer authorId:authorIds) {
            Author author = authorRepository.findById(authorId).orElse(null);
            if (author != null){
                book.getAuthors().add(author);
            } else {
                //exception handling
            }
        }

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

    /*public void updateBook(String title, String summary, List<Integer> authorIds) {
        book.getTitle();
        book.getSummary();
        book.getAuthors();

    }*/

    public void deleteBook(Integer id) {
        this.bookRepository.deleteById(id);
    }
}
