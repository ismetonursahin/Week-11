package dev.kutuphane.kutuphane.dto.response.Category;

import dev.kutuphane.kutuphane.entities.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private int id;
    private String name ;
    private String description;


}
