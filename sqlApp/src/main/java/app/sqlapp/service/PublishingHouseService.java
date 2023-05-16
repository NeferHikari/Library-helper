package app.sqlapp.service;

import app.sqlapp.model.PublishingHouse;
import app.sqlapp.repository.PublishingHouseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishingHouseService {

    private final PublishingHouseRepository publishingHouseRepository;

    public PublishingHouseService(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    public List<PublishingHouse> getAll() {
        List<PublishingHouse> dto = publishingHouseRepository.findAll();
        List<PublishingHouse> publishingHouses = new ArrayList<>();
        for (PublishingHouse dtoPublishingHouse : dto) {
            PublishingHouse publishingHouse = new PublishingHouse();
            publishingHouse.setId(dtoPublishingHouse.getId());
            publishingHouse.setName(dtoPublishingHouse.getName());
            publishingHouse.setAddress(dtoPublishingHouse.getAddress());
            publishingHouses.add(publishingHouse);
        }
        return publishingHouses;
    }

    public PublishingHouse getPublishingHouseById(Long id) {
        PublishingHouse dtoPublishingHouse = publishingHouseRepository.getReferenceById(id);
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setId(dtoPublishingHouse.getId());
        publishingHouse.setId(dtoPublishingHouse.getId());
        publishingHouse.setName(dtoPublishingHouse.getName());
        publishingHouse.setAddress(dtoPublishingHouse.getAddress());
        return publishingHouse;
    }

    public PublishingHouse addNewPublishingHouse(PublishingHouse publishingHouse) {
        return publishingHouseRepository.save(publishingHouse);
    }

    public void deletePublishingHouseById(Long id) {
        publishingHouseRepository.deleteById(id);
    }

    public PublishingHouse editPublishingHouseById(Long id, PublishingHouse updatedPublishingHouse) {
        PublishingHouse publishingHouseToUpdate = publishingHouseRepository.getReferenceById(id);
        publishingHouseToUpdate.setId(updatedPublishingHouse.getId());
        publishingHouseToUpdate.setName(updatedPublishingHouse.getName());
        publishingHouseToUpdate.setAddress(updatedPublishingHouse.getAddress());
        return publishingHouseRepository.save(publishingHouseToUpdate);
    }
}
