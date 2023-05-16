package app.sqlapp.controller;

import app.sqlapp.model.Book;
import app.sqlapp.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAllCategories() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/add")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @PutMapping("/edit/{bookId}")
    public Book editBook(@PathVariable Long bookId, @RequestBody Book book) {
        return bookService.editBookById(bookId, book);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }
}
