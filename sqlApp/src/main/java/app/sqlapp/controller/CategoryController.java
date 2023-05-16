package app.sqlapp.controller;

import app.sqlapp.model.Category;
import app.sqlapp.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/add")
    public Category addNewCategory(@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    @PutMapping("/edit/{categoryId}")
    public Category editCategory(@PathVariable Long categoryId, @RequestBody Category category) {
        return categoryService.editCategoryById(categoryId, category);
    }

    @DeleteMapping("/delete/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
