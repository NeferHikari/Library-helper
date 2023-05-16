package app.sqlapp.controller;

import app.sqlapp.model.Copy;
import app.sqlapp.service.CopyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copies")
@CrossOrigin(origins = "http://localhost:4200")
public class CopyController {
    private final CopyService copyService;

    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

    @GetMapping("/")
    public List<Copy> getAllCategories() {
        return copyService.getAll();
    }

    @GetMapping("/{copyId}")
    public Copy getCopy(@PathVariable Long copyId) {
        return copyService.getCopyById(copyId);
    }

    @PostMapping("/add")
    public Copy addNewCopy(@RequestBody Copy copy) {
        return copyService.addNewCopy(copy);
    }

    @PutMapping("/edit/{copyId}")
    public Copy editCopy(@PathVariable Long copyId, @RequestBody Copy copy) {
        return copyService.editCopyById(copyId, copy);
    }

    @DeleteMapping("/delete/{copyId}")
    public void deleteCopy(@PathVariable Long copyId) {
        copyService.deleteCopyById(copyId);
    }
}
