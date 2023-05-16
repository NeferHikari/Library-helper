package app.sqlapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "publishingHouse")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;

    public PublishingHouse(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public PublishingHouse() {
    }

    public PublishingHouse(Long id, String name, String address) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
