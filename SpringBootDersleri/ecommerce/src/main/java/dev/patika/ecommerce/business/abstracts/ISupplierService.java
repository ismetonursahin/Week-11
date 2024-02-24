package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import org.springframework.data.domain.Page;


public interface ISupplierService {
    Supplier save(Supplier supplier);
    Supplier get(int id);

    Page<Supplier> cursor(int page, int pageSize); // hangi sayfa , bi sayfada kaç veri

    Supplier update(Supplier supplier);

    boolean delete(int id);
}
