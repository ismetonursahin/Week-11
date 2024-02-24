package dev.patika.ecommerce.dao;

import dev.patika.ecommerce.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier ,Integer> {

}
