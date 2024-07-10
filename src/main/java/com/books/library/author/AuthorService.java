package com.books.library.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void createAuthor(String forename, String surname) {
        Author author = new Author();
        author.setForename(forename);
        author.setSurname(surname);
        this.authorRepository.save(author);
    }
}
