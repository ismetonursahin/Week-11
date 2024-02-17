package dev.patika.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySaveRequest {

    @NotNull
    @NotEmpty
    private String name;
}
