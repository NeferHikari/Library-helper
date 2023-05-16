package app.sqlapp.controller;

import app.sqlapp.model.Reader;
import app.sqlapp.service.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@CrossOrigin(origins = "http://localhost:4200")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/")
    public List<Reader> getAllCategories() {
        return readerService.getAll();
    }

    @GetMapping("/{readerId}")
    public Reader getReader(@PathVariable Long readerId) {
        return readerService.getReaderById(readerId);
    }

    @PostMapping("/add")
    public Reader addNewReader(@RequestBody Reader reader) {
        return readerService.addNewReader(reader);
    }

    @PutMapping("/edit/{readerId}")
    public Reader editReader(@PathVariable Long readerId, @RequestBody Reader reader) {
        return readerService.editReaderById(readerId, reader);
    }

    @DeleteMapping("/delete/{readerId}")
    public void deleteReader(@PathVariable Long readerId) {
        readerService.deleteReaderById(readerId);
    }
}
