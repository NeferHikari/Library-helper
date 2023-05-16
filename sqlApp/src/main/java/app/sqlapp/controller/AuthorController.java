package app.sqlapp.controller;

import app.sqlapp.model.Author;
import app.sqlapp.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200") 
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
 
    @GetMapping("/")
    public List<Author> getAllCategories() {
        return authorService.geTAuthorsList();
    }

 
    @GetMapping("/{authorId}")
    public Author getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthorById(authorId);
    }

 
    @PostMapping("/add")
    public Author addNewAuthor(@RequestBody Author author) {
        return authorService.addNewAuthor(author);
    }

 
    @PutMapping("/edit/{authorId}")
    public Author editAuthor(@PathVariable Long authorId, @RequestBody Author author) {
        return authorService.editAuthorById(authorId, author);
    }
 
    @DeleteMapping("/delete/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
    }
}
