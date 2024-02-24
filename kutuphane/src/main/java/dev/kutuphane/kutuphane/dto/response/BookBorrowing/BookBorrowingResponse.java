package dev.kutuphane.kutuphane.dto.response.BookBorrowing;

import dev.kutuphane.kutuphane.entities.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {

    private int id;

    private String name;

    private LocalDate borrowingDate;

    private LocalDate returnDate;


}
