package dev.patika.spring.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="customer_id" , columnDefinition = "serial")
    @NotNull
    private int id;

    @Column(name = "customer_name" , length = 100 , nullable = false)
    private String name ;

    @Column(name = "customer_mail" , unique = true ,nullable = false)
    @Email(message = "Geçerli bir e-posta giriniz.")
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;

    public enum GENDER{
        MALE,
        FEMALE
    }


}
