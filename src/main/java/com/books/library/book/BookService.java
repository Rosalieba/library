package com.books.library.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public List<String> getBooks() {
        return List.of("Hi", "Books", ":-)");
    }


}
