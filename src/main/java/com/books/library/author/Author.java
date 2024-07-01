package com.books.library.author;

import com.books.library.book.Book;
import com.books.library.sub_subject.SubSubject;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {
    //region members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String forename;
    private String surname;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
    @ManyToMany
    @JoinColumn(name = "id")
    private Subject subject;

    @ManyToMany
    @JoinColumn(name ="id")
    private SubSubject subSubject;
    //endregion

    //region constructor

    public Author(Integer id, String forename, String surname, List<Book> books, Subject subject, SubSubject subSubject) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.books = books;
        this.subject = subject;
        this.subSubject = subSubject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubSubject getSubSubject() {
        return subSubject;
    }

    public void setSubSubject(SubSubject subSubject) {
        this.subSubject = subSubject;
    }
    //endregion

    //region equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(id, author.id) && Objects.equals(forename, author.forename) && Objects.equals(surname, author.surname) && Objects.equals(books, author.books) && Objects.equals(subject, author.subject) && Objects.equals(subSubject, author.subSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forename, surname, books, subject, subSubject);
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
                ", subject=" + subject +
                ", subSubject=" + subSubject +
                '}';
    }

    //endregion
}
