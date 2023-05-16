package app.sqlapp.model;

import jakarta.persistence.*;
import app.sqlapp.model.CopyStatus;

@Entity
@Table(name = "copy")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "id")
    Long id;
    @Column(name = "status")
    String status;
    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;
    public Copy() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
