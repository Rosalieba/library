package com.books.library.book;


import com.books.library.author.Author;
import com.books.library.sub_subject.SubSubject;
import com.books.library.subject.Subject;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Book {
    //region members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    @JoinColumn(name = "author_id")
    private Author author;
    private String summary;
    private Date publicationDate;
    private String readerCategory;
    private String bookCategory;
    @ManyToMany
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToMany
    @JoinColumn(name ="sub_subject_id")
    private SubSubject subSubject;
    //endregion

    //region constructor
    public Book(Integer id, String title, Author author, String summary, Date publicationDate, String readerCategory, String bookCategory, Subject subject, SubSubject subSubject) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.readerCategory = readerCategory;
        this.bookCategory = bookCategory;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    //region equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(summary, book.summary) && Objects.equals(publicationDate, book.publicationDate) && Objects.equals(readerCategory, book.readerCategory) && Objects.equals(bookCategory, book.bookCategory) && Objects.equals(subject, book.subject) && Objects.equals(subSubject, book.subSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, summary, publicationDate, readerCategory, bookCategory, subject, subSubject);
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", summary='" + summary + '\'' +
                ", publicationDate=" + publicationDate +
                ", readerCategory='" + readerCategory + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", subject=" + subject +
                ", subSubject=" + subSubject +
                '}';
    }
    //endregion
}
