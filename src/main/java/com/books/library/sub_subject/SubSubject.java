package com.books.library.sub_subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sub_subject")
public class SubSubject {
    //region members
    @Id
    @SequenceGenerator(
            name = "sub_subject_sequence",
            sequenceName =  "sub_subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sub_subject_sequence"
    )
    private Integer id;
    private String subSubjectName;
    @ManyToMany(mappedBy = "subSubjects")
    private List<Book> books;
    @ManyToMany(mappedBy = "subSubjects")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name ="subject-id")
    private Subject subject;
    //endregion

    //region constructor

    public SubSubject(Integer id, String subSubjectName, List<Book> books, List<Author> authors, Subject subject) {
        this.id = id;
        this.subSubjectName = subSubjectName;
        this.books = books;
        this.authors = authors;
        this.subject = subject;
    }
    //endregion

    //region getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubSubjectName() {
        return subSubjectName;
    }

    public void setSubSubjectName(String subSubjectName) {
        this.subSubjectName = subSubjectName;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    //endregion

    //region equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubSubject that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(subSubjectName, that.subSubjectName) && Objects.equals(books, that.books) && Objects.equals(authors, that.authors) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subSubjectName, books, authors, subject);
    }


    //endregion

    //region toString

    @Override
    public String toString() {
        return "SubSubject{" +
                "id=" + id +
                ", subSubjectName='" + subSubjectName + '\'' +
                ", books=" + books +
                ", authors=" + authors +
                ", subject=" + subject +
                '}';
    }
    //endregion
}
