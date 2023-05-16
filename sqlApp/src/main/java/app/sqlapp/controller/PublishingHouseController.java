package app.sqlapp.controller;

import app.sqlapp.model.PublishingHouse;
import app.sqlapp.service.PublishingHouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishingHouses")
@CrossOrigin(origins = "http://localhost:4200")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @GetMapping("/")
    public List<PublishingHouse> getAllCategories() {
        return publishingHouseService.getAll();
    }

    @GetMapping("/{publishingHouseId}")
    public PublishingHouse getPublishingHouse(@PathVariable Long publishingHouseId) {
        return publishingHouseService.getPublishingHouseById(publishingHouseId);
    }

    @PostMapping("/add")
    public PublishingHouse addNewPublishingHouse(@RequestBody PublishingHouse publishingHouse) {
        return publishingHouseService.addNewPublishingHouse(publishingHouse);
    }

    @PutMapping("/edit/{publishingHouseId}")
    public PublishingHouse editPublishingHouse(@PathVariable Long publishingHouseId, @RequestBody PublishingHouse publishingHouse) {
        return publishingHouseService.editPublishingHouseById(publishingHouseId, publishingHouse);
    }

    @DeleteMapping("/delete/{publishingHouseId}")
    public void deletePublishingHouse(@PathVariable Long publishingHouseId) {
        publishingHouseService.deletePublishingHouseById(publishingHouseId);
    }
}
