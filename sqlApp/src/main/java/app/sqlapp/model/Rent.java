package app.sqlapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "id")
    Long id;
    @Column(name = "rentalDate")
    Date rentalDate;
    @Column(name = "returnDate")
    Date returnDate;
    @Column(name = "returnExpectedDate")
    Date returnExpectedDate;
    @ManyToOne
    @JoinColumn(name = "copyId", nullable = false)
    private Copy copy;
    @ManyToOne
    @JoinColumn(name = "readerId", nullable = false)
    private Reader reader;

    public Rent() {
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnExpectedDate() {
        return returnExpectedDate;
    }

    public void setReturnExpectedDate(Date returnExpectedDate) {
        this.returnExpectedDate = returnExpectedDate;
    }
}
