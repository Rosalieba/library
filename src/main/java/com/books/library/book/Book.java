package com.books.library.book;

import com.books.library.author.Author;
import com.books.library.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "books")
public class Book {
    //region members
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Integer id;
    private String title;

    @ManyToMany
    @JoinTable(
            name= "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();
    private String summary;
    private Date publicationDate;
    private String readerCategory;
    private String bookCategory;
    private String isbn;

    @ManyToMany
    @JoinTable(
            name = "books_subjects",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();

    private Set<String> subSubjects = new HashSet<>();
    //endregion

    //region constructor
    public Book() {
    }
    //endregion

    //region getter and setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getReaderCategory() {
        return readerCategory;
    }

    public void setReaderCategory(String readerCategory) {
        this.readerCategory = readerCategory;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubSubject(Set<String> subSubjects) {
        this.subSubjects = subSubjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getSubSubjects() {
        return subSubjects;
    }

    public void setSubSubjects(Set<String> subSubjects) {
        this.subSubjects = subSubjects;
    }
//endregion

    //region equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //endregion

    //region toString

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + authors +
                ", summary='" + summary + '\'' +
                ", publicationDate=" + publicationDate +
                ", readerCategory='" + readerCategory + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", isbn='" + isbn + '\'' +
                ", subjects=" + subjects +
                ", subSubjects=" + subSubjects +
                '}';
    }


    //endregion
}
