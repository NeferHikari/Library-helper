package app.sqlapp.service;

import app.sqlapp.model.Book;
import app.sqlapp.model.Copy;
import app.sqlapp.repository.BookRepository;
import app.sqlapp.repository.CopyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;

    public CopyService(CopyRepository copyRepository, BookRepository bookRepository) {
        this.copyRepository = copyRepository;
        this.bookRepository = bookRepository;
    }

    public List<Copy> getAll() {
        List<Copy> dto = copyRepository.findAll();
        List<Copy> copies = new ArrayList<>();
        for (Copy dtoCopy : dto) {
            Copy copy = new Copy();
            copy.setId(dtoCopy.getId());
            copy.setBook(dtoCopy.getBook());
            copy.setStatus(dtoCopy.getStatus());
            copies.add(copy);
        }
        return copies;
    }

    public Copy getCopyById(Long id) {
        Copy dtoCopy = copyRepository.getReferenceById(id);
        Copy copy = new Copy();
        copy.setId(dtoCopy.getId());
        copy.setBook(dtoCopy.getBook());
        copy.setStatus(dtoCopy.getStatus());
        return copy;
    }

    public Copy addNewCopy(Copy copy) {
        Copy newCopy=new Copy();
        newCopy.setStatus(copy.getStatus());
        Book book= bookRepository.findTop1ByTitleAndAndAuthor_NameAndAuthor_Surname(copy.getBook().getTitle(),copy.getBook().getAuthor().getName(),copy.getBook().getAuthor().getSurname());
        newCopy.setBook(book);
        return copyRepository.save(newCopy);
    }

    public void deleteCopyById(Long id) {
        copyRepository.deleteById(id);
    }

    public Copy editCopyById(Long id, Copy updatedCopy) {
        Copy copyToUpdate = copyRepository.getReferenceById(id);
        copyToUpdate.setId(updatedCopy.getId());
        copyToUpdate.setBook(updatedCopy.getBook());
        copyToUpdate.setStatus(updatedCopy.getStatus());
        return copyRepository.save(copyToUpdate);
    }
}
