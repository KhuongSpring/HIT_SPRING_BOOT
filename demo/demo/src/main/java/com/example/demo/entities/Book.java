package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String name;

    String description;

    @DecimalMin(value = "0.1")
    double price;

    @ManyToOne
    @JoinColumn(name = "Author_id")
    Author author;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    Category category;

}
