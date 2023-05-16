package app.sqlapp.service;

import app.sqlapp.model.*;
import app.sqlapp.repository.CopyRepository;
import app.sqlapp.repository.ReaderRepository;
import app.sqlapp.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {
    private final RentRepository rentRepository;
    private final CopyRepository copyRepository;
    private final ReaderRepository readerRepository;


    public RentService(RentRepository rentRepository, CopyRepository copyRepository, ReaderRepository readerRepository) {
        this.rentRepository = rentRepository;
        this.copyRepository = copyRepository;
        this.readerRepository = readerRepository;
    }

    public List<Rent> getAll() {
        List<Rent> dto = rentRepository.findAll();
        List<Rent> rents = new ArrayList<>();
        for (Rent dtoRent : dto) {
            Rent rent = new Rent();
            rent.setId(dtoRent.getId());
            rent.setCopy(dtoRent.getCopy());
            rent.setReader(dtoRent.getReader());
            rent.setRentalDate(dtoRent.getRentalDate());
            rent.setReturnDate(dtoRent.getReturnDate());
            rent.setReturnExpectedDate(dtoRent.getReturnExpectedDate());
            rents.add(rent);
        }
        return rents;
    }

    public Rent getRentById(Long id) {
        Rent dtoRent = rentRepository.getReferenceById(id);
        Rent rent = new Rent();
        rent.setId(dtoRent.getId());
        rent.setCopy(dtoRent.getCopy());
        rent.setReader(dtoRent.getReader());
        rent.setRentalDate(dtoRent.getRentalDate());
        rent.setReturnDate(dtoRent.getReturnDate());
        rent.setReturnExpectedDate(dtoRent.getReturnExpectedDate());
        return rent;
    }

    public Rent addNewRent(Rent rent) {
        Rent newRent=new Rent();
        newRent.setReturnDate(rent.getReturnDate());
        newRent.setRentalDate(rent.getRentalDate());
        newRent.setReturnExpectedDate(rent.getReturnExpectedDate());
        Copy copy = copyRepository.getReferenceById(rent.getCopy().getId());
        Reader reader=readerRepository.findTop1ByNameAndSurname(rent.getReader().getName(),rent.getReader().getSurname());
        newRent.setReader(reader);
        newRent.setCopy(copy);
        return rentRepository.save(newRent);
    }

    public void deleteRentById(Long id) {
        rentRepository.deleteById(id);
    }

    public Rent editRentById(Long id, Rent updatedRent) {
        Rent rentToUpdate = rentRepository.getReferenceById(id);
        rentToUpdate.setId(updatedRent.getId());
        Copy copy=copyRepository.getReferenceById(updatedRent.getCopy().getId());
        rentToUpdate.setCopy(copy);
        rentToUpdate.setReader(updatedRent.getReader());
        rentToUpdate.setRentalDate(updatedRent.getRentalDate());
        rentToUpdate.setReturnDate(updatedRent.getReturnDate());
        rentToUpdate.setReturnExpectedDate(updatedRent.getReturnExpectedDate());
        return rentRepository.save(rentToUpdate);
    }
}
