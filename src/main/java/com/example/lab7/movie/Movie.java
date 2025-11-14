package com.example.lab7.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer year;

    public MovieDto toDto() {
        MovieDto dto = new MovieDto();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setAuthor(this.author);
        dto.setYear(this.year);
        return dto;
    }
}
