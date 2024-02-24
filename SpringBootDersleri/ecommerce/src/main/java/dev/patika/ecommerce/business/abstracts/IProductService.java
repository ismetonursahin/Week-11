package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.dao.ProductRepo;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import org.springframework.data.domain.Page;

public interface IProductService{
    Product save(Product product);
    Product get(int id);

    Page<Product> cursor(int page, int pageSize); // hangi sayfa , bi sayfada kaç veri

    Product update(Product product);

    boolean delete(int id);
}
