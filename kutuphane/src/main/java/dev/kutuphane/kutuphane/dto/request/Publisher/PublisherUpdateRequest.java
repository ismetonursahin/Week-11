package dev.kutuphane.kutuphane.dto.request.Publisher;

import dev.kutuphane.kutuphane.entities.Book;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherUpdateRequest {

    private int id;

    private String name;

    private String establishmentYear;

    private String address;

}
