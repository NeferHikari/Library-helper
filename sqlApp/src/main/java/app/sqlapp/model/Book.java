package app.sqlapp.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "numberOfPages")
    private int numberOfPages;
    @Column(name = "dateOfPublication")
    private Date dateOfPublication;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publishingHouseId")
    private PublishingHouse publishingHouse;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book(String title, Long authorId, Long publishingHouseId, Long categoryId, int numberOfPages, Date dateOfPublication) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.dateOfPublication = dateOfPublication;
        this.author = new Author();
        this.author.setId(authorId);
        this.publishingHouse = new PublishingHouse();
        this.publishingHouse.setId(publishingHouseId);
        this.category = new Category();
        this.category.setId(categoryId);
    }

    public Book( String title, int numberOfPages, Date dateOfPublication, Author author, PublishingHouse publishingHouse, Category category) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.dateOfPublication = dateOfPublication;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.category = category;
    }

    public Book() {}

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
