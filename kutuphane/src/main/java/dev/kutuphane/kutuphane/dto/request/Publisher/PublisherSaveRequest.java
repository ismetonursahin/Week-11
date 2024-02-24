package dev.kutuphane.kutuphane.dto.request.Publisher;

import dev.kutuphane.kutuphane.entities.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherSaveRequest {

    @NotNull(message = "İsim Boş Olamaz")
    private String name;

    private String establishmentYear;

    private String address;

}
