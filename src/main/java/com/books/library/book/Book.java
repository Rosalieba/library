package com.books.library.book;


import com.books.library.author.Author;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    private List<Author> authors = new ArrayList<>();
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
    private List<Subject> subjects = new ArrayList<>();

    private List<String> subSubjects;
    //endregion

    //region constructor
    public Book() {
    }

    /*public Book(Integer id, String title, List<Integer> authors, String summary, Date publicationDate, String readerCategory, String bookCategory, String isbn, List<Subject> subjects, List<String> subSubjects) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.readerCategory = readerCategory;
        this.bookCategory = bookCategory;
        this.isbn = isbn;
        this.subjects = subjects;
        this.subSubjects = subSubjects;
    }*/
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubSubject(List<String> subSubjects) {
        this.subSubjects = subSubjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getSubSubjects() {
        return subSubjects;
    }

    public void setSubSubjects(List<String> subSubjects) {
        this.subSubjects = subSubjects;
    }
//endregion

    //region equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(summary, book.summary) && Objects.equals(publicationDate, book.publicationDate) && Objects.equals(readerCategory, book.readerCategory) && Objects.equals(bookCategory, book.bookCategory) && Objects.equals(isbn, book.isbn) && Objects.equals(subjects, book.subjects) && Objects.equals(subSubjects, book.subSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, summary, publicationDate, readerCategory, bookCategory, isbn, subjects, subSubjects);
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
