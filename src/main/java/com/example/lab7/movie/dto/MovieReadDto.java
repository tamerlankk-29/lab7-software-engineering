package com.example.lab7.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieReadDto {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private DirectorDto director;
    private List<TagDto> tags;
}
