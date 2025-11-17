package com.example.lab7.movie.mapper;

import com.example.lab7.movie.entity.Movie;
import com.example.lab7.movie.dto.MovieReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {DirectorMapper.class, TagMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    MovieReadDto toReadDto(Movie entity);
}
