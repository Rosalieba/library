package com.books.library.sub_subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SubSubject {
    //region members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subSubjectName;
    @ManyToMany
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToMany
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name ="subject_id")
    private Subject subject;
    //endregion

    //region constructor
    public SubSubject(Integer id, String subSubjectName, Book book, Author author, Subject subject) {
        this.id = id;
        this.subSubjectName = subSubjectName;
        this.book = book;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
        return Objects.equals(id, that.id) && Objects.equals(subSubjectName, that.subSubjectName) && Objects.equals(book, that.book) && Objects.equals(author, that.author) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subSubjectName, book, author, subject);
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "SubSubject{" +
                "id=" + id +
                ", subSubjectName='" + subSubjectName + '\'' +
                ", book=" + book +
                ", author=" + author +
                ", subject=" + subject +
                '}';
    }
    //endregion
}
