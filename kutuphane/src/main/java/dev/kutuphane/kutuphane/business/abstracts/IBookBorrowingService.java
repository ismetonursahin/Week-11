package dev.kutuphane.kutuphane.business.abstracts;

import dev.kutuphane.kutuphane.entities.Book;
import dev.kutuphane.kutuphane.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(int id);

    Page<BookBorrowing> cursor(int page, int pageSize); // hangi sayfa , bi sayfada kaç veri

    BookBorrowing update(BookBorrowing bookBorrowing);

    boolean delete(int id);
}
