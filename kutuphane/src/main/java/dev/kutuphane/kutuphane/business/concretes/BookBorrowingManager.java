package dev.kutuphane.kutuphane.business.concretes;

import dev.kutuphane.kutuphane.business.abstracts.IAuthorService;
import dev.kutuphane.kutuphane.business.abstracts.IBookBorrowingService;
import dev.kutuphane.kutuphane.dao.BookBorrowingRepo;
import dev.kutuphane.kutuphane.entities.BookBorrowing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBorrowingManager implements IBookBorrowingService {

    private final BookBorrowingRepo bookBorrowingRepo;
    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(int id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow();
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.bookBorrowingRepo.findAll(pageable);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        this.get(bookBorrowing.getId());
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public boolean delete(int id) {
        BookBorrowing bookBorrowing = this.get(id);
        this.bookBorrowingRepo.delete(bookBorrowing);
        return true;
    }
}
