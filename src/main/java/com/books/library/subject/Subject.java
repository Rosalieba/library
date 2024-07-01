package com.books.library.subject;

import com.books.library.author.Author;
import com.books.library.book.Book;
import com.books.library.sub_subject.SubSubject;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject {
    //region members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subjectName;
    @ManyToMany(mappedBy = "subjects")
    private List<Book> books;
    @ManyToMany
    @JoinColumn(name = "id")
    private Author author;

    @OneToMany
    @JoinColumn(name ="id")
    private SubSubject subSubject;
    //endregion

    //region constructor

    public Subject(Integer id, String subjectName, List<Book> books, Author author, SubSubject subSubject) {
        this.id = id;
        this.subjectName = subjectName;
        this.books = books;
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
        return Objects.equals(id, subject.id) && Objects.equals(subjectName, subject.subjectName) && Objects.equals(books, subject.books) && Objects.equals(author, subject.author) && Objects.equals(subSubject, subject.subSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName, books, author, subSubject);
    }

    //endregion

    //region toString

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", books=" + books +
                ", author=" + author +
                ", subSubject=" + subSubject +
                '}';
    }

    //endregion
}
