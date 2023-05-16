package app.sqlapp.repository;

import app.sqlapp.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findTop1ByNameAndSurname(String name,String surname);
}
