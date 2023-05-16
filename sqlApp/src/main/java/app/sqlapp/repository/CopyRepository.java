package app.sqlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.sqlapp.model.Copy;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
}
