package dev.kutuphane.kutuphane.dao;

import dev.kutuphane.kutuphane.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
