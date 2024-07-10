package com.books.library.book;

import com.books.library.author.Author;
import com.books.library.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;



    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public void createBook(String title, String summary, List<Integer> authorIds)
    {
        Book book = new Book();
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
       this.bookRepository.save(book);
    }
}
