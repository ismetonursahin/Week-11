package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.dao.CategoryRepo;
import dev.patika.ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;


public interface ICategoryService {
    Category save(Category category);
    Category get(int id);

    Page<Category> cursor(int page, int pageSize); // hangi sayfa , bi sayfada kaç veri

    Category update(Category category);

    boolean delete(int id);

}
