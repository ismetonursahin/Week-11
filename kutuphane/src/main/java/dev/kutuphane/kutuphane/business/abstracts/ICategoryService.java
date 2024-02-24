package dev.kutuphane.kutuphane.business.abstracts;

import dev.kutuphane.kutuphane.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save(Category category);
    Category get(int id);

    Page<Category> cursor(int page, int pageSize); // hangi sayfa , bi sayfada kaç veri

    Category update(Category category);

    boolean delete(int id);
}
