package com.books.library.author;

import com.books.library.book.Book;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "authors")
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
    @ManyToMany
    @JoinTable(
            name= "books_authors",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "authors_subjects",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")}
    )
    private Set<Subject> subjects = new HashSet<>();


    private List<String> subSubjects = new ArrayList<>();
    //endregion

    //region constructor
    public Author(){}
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
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
