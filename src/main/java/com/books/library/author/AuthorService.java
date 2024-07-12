package com.books.library.author;

import com.books.library.subject.Subject;
import com.books.library.subject.SubjectRepository;
import com.books.library.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void createAuthor(String forename, String surname, List<Integer> subjectIds) {
        Author author = new Author();
        author.setForename(forename);
        author.setSurname(surname);
        for (Integer subjectId: subjectIds) {
            Subject subject = subjectRepository.findById(subjectId).orElse(null);
            if (subject != null) {
                author.getSubjects().add(subject);
            } else {
                //handling exception
            }
        }
        this.authorRepository.save(author);
    }

    public void deleteAuthor(Integer id) {
        this.authorRepository.deleteById(id);
    }
}
