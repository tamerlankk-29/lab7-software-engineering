package com.example.lab7.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private String author;
    private Integer year;

    public Movie toEntity() {
        return Movie.builder()
                .id(this.id)
                .title(this.title)
                .author(this.author)
                .year(this.year)
                .build();
    }
}
