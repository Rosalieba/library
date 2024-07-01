package com.books.library.sub_subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class SubSubject {
    //region members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subSubjectName;
    @ManyToMany(mappedBy = "sub_subjects")
    private List<Book> books;
    @ManyToMany
    @JoinColumn(name = "id")
    private Author author;

    @ManyToOne
    @JoinColumn(name ="id")
    private Subject subject;
    //endregion

    //region constructor

    public SubSubject(Integer id, String subSubjectName, List<Book> books, Author author, Subject subject) {
        this.id = id;
        this.subSubjectName = subSubjectName;
        this.books = books;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
        return Objects.equals(id, that.id) && Objects.equals(subSubjectName, that.subSubjectName) && Objects.equals(books, that.books) && Objects.equals(author, that.author) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subSubjectName, books, author, subject);
    }

    //endregion

    //region toString

    @Override
    public String toString() {
        return "SubSubject{" +
                "id=" + id +
                ", subSubjectName='" + subSubjectName + '\'' +
                ", books=" + books +
                ", author=" + author +
                ", subject=" + subject +
                '}';
    }

    //endregion
}
