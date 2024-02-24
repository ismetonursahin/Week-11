package dev.kutuphane.kutuphane.dao;

import dev.kutuphane.kutuphane.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher ,Integer> {
}
