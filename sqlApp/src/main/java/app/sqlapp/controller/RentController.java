package app.sqlapp.controller;

import app.sqlapp.model.Rent;
import app.sqlapp.service.RentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
@CrossOrigin(origins = "http://localhost:4200")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/")
    public List<Rent> getAllCategories() {
        return rentService.getAll();
    }

    @GetMapping("/{rentId}")
    public Rent getRent(@PathVariable Long rentId) {
        return rentService.getRentById(rentId);
    }

    @PostMapping("/add")
    public Rent addNewRent(@RequestBody Rent rent) {
        return rentService.addNewRent(rent);
    }

    @PutMapping("/edit/{rentId}")
    public Rent editRent(@PathVariable Long rentId, @RequestBody Rent rent) {
        return rentService.editRentById(rentId, rent);
    }

    @DeleteMapping("/delete/{rentId}")
    public void deleteRent(@PathVariable Long rentId) {
        rentService.deleteRentById(rentId);
    }
}

