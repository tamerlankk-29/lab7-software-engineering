package com.example.lab7.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private String author;
    private Integer year;

    public Movie toEntity() {
        Movie m = new Movie();
        m.setId(this.id);
        m.setTitle(this.title);
        m.setAuthor(this.author);
        m.setYear(this.year);
        return m;
    }
}
