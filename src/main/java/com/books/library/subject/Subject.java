package com.books.library.subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "subjects")
public class Subject {

    //region members
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    private Integer id;
    private String subjectName;
    @ManyToMany
    @JoinTable(
            name = "books_subjects",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "authors_subjects",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable (
        name = "subsubjects",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "subsubject_id")
    )
    private Set<Subject> subSubjects = new HashSet<>();
    //endregion

    //region constructor
    public Subject() {}

    //endregion

    //region getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Subject> getSubSubjects() {
        return subSubjects;
    }

    public void setSubSubjects(Set<Subject> subSubjects) {
        this.subSubjects = subSubjects;
    }

    //endregion

    //region equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(id, subject.id) && Objects.equals(subjectName, subject.subjectName) && Objects.equals(books, subject.books) && Objects.equals(authors, subject.authors) && Objects.equals(subSubjects, subject.subSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName, books, authors, subSubjects);
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", books=" + books +
                ", authors=" + authors +
                ", subSubjects=" + subSubjects +
                '}';
    }
    //endregion
}
