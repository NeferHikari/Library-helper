package app.sqlapp.repository;

import app.sqlapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findTop1ByNameAndSurname(String name, String surname);
}
