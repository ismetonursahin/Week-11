package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.dao.CategoryRepo;
import dev.patika.ecommerce.entities.Category;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
    Category save(Category category);
}
