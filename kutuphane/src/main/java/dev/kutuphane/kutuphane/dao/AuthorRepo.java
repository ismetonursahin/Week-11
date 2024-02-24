package dev.kutuphane.kutuphane.dao;

import dev.kutuphane.kutuphane.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
