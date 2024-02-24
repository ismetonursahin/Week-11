package dev.kutuphane.kutuphane.business.concretes;

import dev.kutuphane.kutuphane.business.abstracts.IAuthorService;
import dev.kutuphane.kutuphane.dao.AuthorRepo;
import dev.kutuphane.kutuphane.entities.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.JpaEntityGraph;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // private final gelecek olan constructor burada oluştu.
public class AuthorManager implements IAuthorService {
    private final AuthorRepo authorRepo;

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public Author get(int id) {
        return this.authorRepo.findById(id).orElseThrow();
    }

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.authorRepo.findAll(pageable);
    }

    @Override
    public Author update(Author author) {
        this.get(author.getId());
        return this.authorRepo.save(author);
    }

    @Override
    public boolean delete(int id) {
        Author author = this.get(id);
        this.authorRepo.delete(author);
        return true;
    }
}
