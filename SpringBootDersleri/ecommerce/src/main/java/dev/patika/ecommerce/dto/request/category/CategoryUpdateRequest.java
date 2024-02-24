package dev.patika.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequest {

    @Positive(message = "ID Değeri Pozitif Sayı Olmak Zorundadır")
    private int id;

    @NotNull(message = "Kategori adı boş veya null olamaz.")
    private String name;
}


