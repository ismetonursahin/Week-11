package dev.patika.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id",columnDefinition = "serial")
    private int id;

    @Column(name = "product_name",nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private double price;

    @Column(name = "product_stock",nullable = false)
    private int stock;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_supplier_id" , referencedColumnName = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id" , referencedColumnName = "category_id")
    private Category category;


}
