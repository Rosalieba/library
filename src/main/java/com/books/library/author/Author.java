package com.books.library.author;

import com.books.library.book.Book;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {
    //region members
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private Integer id;
    private String forename;
    private String surname;
    @ManyToMany(mappedBy = "author")
    private List<Book> books;
    @ManyToMany
    @JoinTable(
            name = "author-subject",
            joinColumns = {@JoinColumn(name = "author-id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")}
    )
    private List<Subject> subjects;

    @ManyToMany
    @JoinTable(
            name= "author-sub_subject",
            joinColumns = {@JoinColumn(name = "author-id")},
            inverseJoinColumns = {@JoinColumn(name = "sub_subject_id")}
    )
    private List<String> subSubjects;
    //endregion

    //region constructor

    public Author(Integer id, String forename, String surname, List<Book> books, List<Subject> subjects, List<String> subSubjects) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.books = books;
        this.subjects = subjects;
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

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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
        if (!(o instanceof Author author)) return false;
        return Objects.equals(id, author.id) && Objects.equals(forename, author.forename) && Objects.equals(surname, author.surname) && Objects.equals(books, author.books) && Objects.equals(subjects, author.subjects) && Objects.equals(subSubjects, author.subSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forename, surname, books, subjects, subSubjects);
    }


    //endregion

    //region toString

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", books=" + books +
                ", subjects=" + subjects +
                ", subSubjects=" + subSubjects +
                '}';
    }

    //endregion
}
