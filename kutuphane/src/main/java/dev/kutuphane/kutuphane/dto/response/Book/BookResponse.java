package dev.kutuphane.kutuphane.dto.response.Book;

import dev.kutuphane.kutuphane.entities.Author;
import dev.kutuphane.kutuphane.entities.Category;
import dev.kutuphane.kutuphane.entities.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private int id;

    private String name;

    private String publicationYear;

    private int stock;

    private Author author;

    private List<Category> categoryList;

    private Publisher publisher;
}
