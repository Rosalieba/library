package com.books.library.subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import com.books.library.sub_subject.SubSubject;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Subject {
    //region members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;
    @ManyToMany
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToMany
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany
    @JoinColumn(name ="sub_subject_id")
    private SubSubject subSubject;
    //endregion

    //region constructor
    public Subject(Integer id, String subjectName, Book book, Author author, SubSubject subSubject) {
        this.id = id;
        this.subjectName = subjectName;
        this.book = book;
        this.author = author;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(id, subject.id) && Objects.equals(subjectName, subject.subjectName) && Objects.equals(book, subject.book) && Objects.equals(author, subject.author) && Objects.equals(subSubject, subject.subSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName, book, author, subSubject);
    }
    //endregion

    //region toString

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", book=" + book +
                ", author=" + author +
                ", subSubject=" + subSubject +
                '}';
    }

    //endregion
}
