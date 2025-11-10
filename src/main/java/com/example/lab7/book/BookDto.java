package com.example.lab7.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private String isbn;

    public Book toEntity() {
        return Book.builder()
                .id(this.id)
                .title(this.title)
                .author(this.author)
                .year(this.year)
                .isbn(this.isbn)
                .build();
    }
}
