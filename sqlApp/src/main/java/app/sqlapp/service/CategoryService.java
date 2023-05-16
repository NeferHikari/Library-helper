package app.sqlapp.service;

import app.sqlapp.model.Category;
import app.sqlapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        List<Category> dto = categoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for (Category dtoCategory : dto) {
            Category category = new Category();
            category.setId(dtoCategory.getId());
            category.setName(dtoCategory.getName());
            categories.add(category);
        }
        return categories;
    }

    public Category getCategoryById(Long id) {
        Category dto = categoryRepository.getReferenceById(id);
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    public Category addNewCategory(Category category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        return categoryRepository.save(newCategory);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category editCategoryById(Long id, Category updatedCategory) {
        Category categoryToUpdate = categoryRepository.getReferenceById(id);
        categoryToUpdate.setName(updatedCategory.getName());
        return categoryRepository.save(categoryToUpdate);
    }
}