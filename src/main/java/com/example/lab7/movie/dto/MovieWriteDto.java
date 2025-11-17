package com.example.lab7.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieWriteDto {
    private String title;
    private String author;
    private Integer year;
    private Long directorId;
    private List<Long> tagIds;
}
