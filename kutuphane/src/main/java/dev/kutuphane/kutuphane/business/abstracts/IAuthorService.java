package dev.kutuphane.kutuphane.business.abstracts;

import dev.kutuphane.kutuphane.entities.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService {
    Author save(Author author);
    Author get(int id);

    Page<Author> cursor(int page, int pageSize);

    Author update(Author category);

    boolean delete(int id);
}
