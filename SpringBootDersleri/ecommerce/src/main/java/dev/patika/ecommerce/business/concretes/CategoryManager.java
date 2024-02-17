package dev.patika.ecommerce.business.concretes;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.dao.CategoryRepo;
import dev.patika.ecommerce.entities.Category;


public class CategoryManager implements ICategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }
}
