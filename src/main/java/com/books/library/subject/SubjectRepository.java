package com.books.library.subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    public Subject findOneBySubjectName(String name);

}