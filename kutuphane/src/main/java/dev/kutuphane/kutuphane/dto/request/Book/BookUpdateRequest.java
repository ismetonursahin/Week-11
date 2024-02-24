package dev.kutuphane.kutuphane.dto.request.Book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.kutuphane.kutuphane.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    @Positive(message = "id boş olamaz")
    private int id;
    @NotNull(message = "isim boş olamaz")
    private String name;
    @NotNull(message = "yıl boş olamaz")
    private String publicationYear;
    @NotNull(message = "stok boş bırakılamaz")
    private int stock;

    private int authorId; // many to one

    private List<Category> categoryList; // manytomany

    private int publisherId;  // many to one

}
