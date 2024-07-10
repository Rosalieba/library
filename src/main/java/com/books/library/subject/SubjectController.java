package com.books.library.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects() {
        return this.subjectService.getSubjects();
    }

    @PostMapping
    public void createSubject(@RequestBody AddSubjectRequest request) {
        this.subjectService.createSubject(request.subjectName(), request.bookIds());
    }

    public record AddSubjectRequest(String subjectName, List<Integer> bookIds) {}
}
