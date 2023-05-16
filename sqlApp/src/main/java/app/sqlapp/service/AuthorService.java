package app.sqlapp.service;

import app.sqlapp.model.Author;
import app.sqlapp.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> geTAuthorsList() {
        List<Author> dto = authorRepository.findAll();
        List<Author> authors = new ArrayList<>();
        for (Author dtoAuthor : dto) {
            Author author = new Author(dtoAuthor.getId(), dtoAuthor.getName(), dtoAuthor.getSurname());
            authors.add(author);
        }
        return authors;
    }

    public Author getAuthorById(Long id) {
        Author author=new Author();
        Author dto = authorRepository.getReferenceById(id);
        if(dto!=null){
        author = new Author(dto.getId(), dto.getName(), dto.getSurname());
        }
        return author;
    }

    public Author addNewAuthor(Author author) {
        Author newAuthor=new Author();
            newAuthor.setName(author.getName());
            newAuthor.setSurname(author.getSurname());
        return authorRepository.save(newAuthor);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public Author editAuthorById(Long id, Author updatedAuthor) {
        Author authorToUpdate = authorRepository.getReferenceById(id);
        authorToUpdate.setName(updatedAuthor.getName());
        authorToUpdate.setSurname(updatedAuthor.getSurname());
        return authorRepository.save(authorToUpdate);
    }
}
