package com.books.library.subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject")
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
    @ManyToMany(mappedBy = "subject")
    private List<Book> books;
    @ManyToMany(mappedBy = "subjects")
    private List<Author> authors;

    private List<String> subSubjects;
    //endregion

    //region constructor

    public Subject(Integer id, String subjectName, List<Book> books, List<Author> authors, List<String> subSubjects) {
        this.id = id;
        this.subjectName = subjectName;
        this.books = books;
        this.authors = authors;
        this.subSubjects = subSubjects;
    }
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getSubSubjects() {
        return subSubjects;
    }

    public void setSubSubjects(List<String> subSubjects) {
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
