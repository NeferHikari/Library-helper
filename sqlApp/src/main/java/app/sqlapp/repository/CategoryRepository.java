package app.sqlapp.repository;

import app.sqlapp.model.Author;
import app.sqlapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findTop1ByName(String name);
}