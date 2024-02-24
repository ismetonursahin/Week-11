package dev.kutuphane.kutuphane.dto.request.Book;

import dev.kutuphane.kutuphane.entities.Author;
import dev.kutuphane.kutuphane.entities.BookBorrowing;
import dev.kutuphane.kutuphane.entities.Category;
import dev.kutuphane.kutuphane.entities.Publisher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {

    @NotNull(message = "Kitap İsmi Boş olamaz")
    private String name;

    @NotNull(message = "Yıl boş olamaz")
    private String publicationYear;

    @NotNull(message = "Stok giriniz")
    private int stock;

    @NotNull(message = "Yazar ID boş bırakılamaz.")
    private int authorId; // many to one

    @NotNull(message = "Kategory gir")
    private List<Category> categoryList; // manytomany

    @NotNull(message = "Publisher ID boş bırakılamaz.")
    private int publisherId;  // many to one



}
