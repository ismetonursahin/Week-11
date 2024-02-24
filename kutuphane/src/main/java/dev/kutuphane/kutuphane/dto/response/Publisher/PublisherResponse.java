package dev.kutuphane.kutuphane.dto.response.Publisher;

import dev.kutuphane.kutuphane.entities.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherResponse {

    private int id;

    private String name;

    private String establishmentYear;

    private String address;

}
