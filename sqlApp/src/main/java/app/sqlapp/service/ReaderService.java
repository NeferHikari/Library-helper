package app.sqlapp.service;

import app.sqlapp.model.Reader;
import app.sqlapp.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public List<Reader> getAll() {
        List<Reader> dto = readerRepository.findAll();
        List<Reader> copies = new ArrayList<>();
        for (Reader dtoReader : dto) {
            Reader reader = new Reader();
            reader.setId(dtoReader.getId());
            reader.setName(dtoReader.getName());
            reader.setSurname(dtoReader.getSurname());
            reader.setEmail(dtoReader.getEmail());
            copies.add(reader);
        }
        return copies;
    }

    public Reader getReaderById(Long id) {
        Reader dtoReader = readerRepository.getReferenceById(id);
        Reader reader = new Reader();
        reader.setId(dtoReader.getId());
        reader.setName(dtoReader.getName());
        reader.setSurname(dtoReader.getSurname());
        reader.setEmail(dtoReader.getEmail());
        return reader;
    }

    public Reader addNewReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }

    public Reader editReaderById(Long id, Reader updatedReader) {
        Reader readerToUpdate = readerRepository.getReferenceById(id);
        readerToUpdate.setId(updatedReader.getId());
        readerToUpdate.setName(updatedReader.getName());
        readerToUpdate.setSurname(updatedReader.getSurname());
        readerToUpdate.setEmail(updatedReader.getEmail());
        return readerRepository.save(readerToUpdate);
    }
}
