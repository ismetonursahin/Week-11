package dev.patika.ecommerce.dto.response.Product;

import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int supplierId;
    private int categoryId;

}
