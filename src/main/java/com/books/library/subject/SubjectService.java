package com.books.library.subject;

import com.books.library.book.Book;
import com.books.library.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Subject> getSubjects() {
        return this.subjectRepository.findAll();
    }

    public void createSubject(String subjectName, List<Integer> bookIds) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        for (Integer bookId:bookIds) {
            Book book = bookRepository.findById(bookId).orElse(null);
            if (bookId != null) {
                book.setId(bookId);
            } else {
                //exception handling
            }
        }
        this.subjectRepository.save(subject);
    }

}
