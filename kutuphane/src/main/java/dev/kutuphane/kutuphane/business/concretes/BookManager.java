package dev.kutuphane.kutuphane.business.concretes;

import dev.kutuphane.kutuphane.business.abstracts.IBookService;
import dev.kutuphane.kutuphane.core.exception.NotFoundException;
import dev.kutuphane.kutuphane.core.utilies.Msg;
import dev.kutuphane.kutuphane.dao.BookRepo;
import dev.kutuphane.kutuphane.entities.Book;
import dev.kutuphane.kutuphane.entities.BookBorrowing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManager implements IBookService {

    private final BookRepo bookRepo;

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book get(int id) {
        return this.bookRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.bookRepo.findAll(pageable);
    }

    @Override
    public Book update(Book book) {
        this.get(book.getId());
        return this.bookRepo.save(book);
    }

    @Override
    public boolean delete(int id) {
        Book book = this.get(id);
        this.bookRepo.delete(book);
        return true;
    }
}