package dev.kutuphane.kutuphane.dao;

import dev.kutuphane.kutuphane.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
