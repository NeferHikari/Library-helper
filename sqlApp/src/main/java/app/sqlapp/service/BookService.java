package app.sqlapp.service;

import app.sqlapp.model.Author;
import app.sqlapp.model.Book;
import app.sqlapp.model.Category;
import app.sqlapp.model.PublishingHouse;
import app.sqlapp.repository.AuthorRepository;
import app.sqlapp.repository.BookRepository;
import app.sqlapp.repository.CategoryRepository;
import app.sqlapp.repository.PublishingHouseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final PublishingHouseRepository houseRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, PublishingHouseRepository houseRepository) {
        this.bookRepository = bookRepository;

        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.houseRepository = houseRepository;
    }

    public List<Book> getAll() {
        List<Book> dto = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (Book dtoBook : dto) {
            Book book = new Book();
            book.setId(dtoBook.getId());
            book.setTitle(dtoBook.getTitle());
            book.setAuthor(dtoBook.getAuthor());
            book.setPublishingHouse(dtoBook.getPublishingHouse());
            book.setCategory(dtoBook.getCategory());
            book.setNumberOfPages(dtoBook.getNumberOfPages());
            book.setDateOfPublication(dtoBook.getDateOfPublication());
            books.add(book);
        }
        return books;
    }

    public Book getBookById(Long id) {
        Book dtoBook = bookRepository.getReferenceById(id);
        Book book = new Book();
        book.setId(dtoBook.getId());
        book.setTitle(dtoBook.getTitle());
        book.setAuthor(dtoBook.getAuthor());
        book.setPublishingHouse(dtoBook.getPublishingHouse());
        book.setCategory(dtoBook.getCategory());
        book.setNumberOfPages(dtoBook.getNumberOfPages());
        book.setDateOfPublication(dtoBook.getDateOfPublication());
        return book;
    }

    public Book addNewBook(Book newBook) {
        Author author=authorRepository.findTop1ByNameAndSurname(newBook.getAuthor().getName(),newBook.getAuthor().getSurname());
        PublishingHouse publishingHouse=houseRepository.findTop1ByNameAndAddress(newBook.getPublishingHouse().getName(),newBook.getPublishingHouse().getAddress());
        Category category=categoryRepository.findTop1ByName(newBook.getCategory().getName());
        Book book = new Book(newBook.getTitle(), newBook.getNumberOfPages(),newBook.getDateOfPublication(),author,publishingHouse,category);
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book editBookById(Long id, Book updatedBook) {
        Author author=authorRepository.findTop1ByNameAndSurname(updatedBook.getAuthor().getName(),updatedBook.getAuthor().getSurname());
        PublishingHouse publishingHouse=houseRepository.findTop1ByNameAndAddress(updatedBook.getPublishingHouse().getName(),updatedBook.getPublishingHouse().getAddress());
        Category category=categoryRepository.findTop1ByName(updatedBook.getCategory().getName());

        Book bookToUpdate = bookRepository.getReferenceById(id);
        bookToUpdate.setId(updatedBook.getId());
        bookToUpdate.setTitle(updatedBook.getTitle());
        bookToUpdate.setAuthor(author);
        bookToUpdate.setPublishingHouse(publishingHouse);
        bookToUpdate.setCategory(category);
        bookToUpdate.setNumberOfPages(updatedBook.getNumberOfPages());
        bookToUpdate.setDateOfPublication(updatedBook.getDateOfPublication());
        return bookRepository.save(bookToUpdate);
    }
}
