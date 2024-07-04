package com.books.library.subject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    public List<String> getSubjects() {return List.of("Hello", "Subjects", ":-)");}

}
