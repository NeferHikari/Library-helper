package app.sqlapp.repository;

import app.sqlapp.model.Author;
import app.sqlapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findTop1ByTitleAndAndAuthor_NameAndAuthor_Surname(String title,String name, String surname);
}
