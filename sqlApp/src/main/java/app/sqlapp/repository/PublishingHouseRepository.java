package app.sqlapp.repository;

import app.sqlapp.model.Author;
import app.sqlapp.model.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse,Long> {
    PublishingHouse findTop1ByNameAndAddress(String name, String address);
}
