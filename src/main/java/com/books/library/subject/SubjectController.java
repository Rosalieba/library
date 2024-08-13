package com.books.library.subject;

import com.books.library.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {

    //region members
    @Autowired
    private SubjectService subjectService;
    //endregion

    //region endpoints
    @GetMapping
    public List<Subject> getSubjects() {
        return this.subjectService.getSubjects();
    }

    @PostMapping
    public void createSubject(@RequestBody AddSubjectRequest request) {
        try {
            this.subjectService.createSubject(request.subjectName(), request.bookIds(),
                    request.authorIds());
        } catch (SubjectService.SubjectAlreadyExistException e) {
            //bad request
        };

    }

    @PatchMapping(path = "{subjectId}")
    public void updateSubject(@PathVariable("subjectId") Integer id, @RequestBody PatchSubjectRequest request) {
        this.subjectService.patchSubject(id, request.subjectName(), request.bookIds(),request.authorIds(),request.subSubjectIds());
    }

    @DeleteMapping(path = "{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Integer id) {
        this.subjectService.deleteSubject(id);
    }
    //endregion

    //region record classes
    public record AddSubjectRequest(String subjectName, List<Integer> bookIds,
                                    List<Integer> authorIds) {}

    public record PatchSubjectRequest(String subjectName, List<Integer> bookIds, List<Integer> authorIds, List<Integer>subSubjectIds){}
    //endregion
}
