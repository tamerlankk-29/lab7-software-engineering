package com.example.lab7.movie.mapper;

import com.example.lab7.movie.dto.DirectorDto;
import com.example.lab7.movie.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorDto toDto(Director entity);
    Director toEntity(DirectorDto dto);
    void updateEntity(DirectorDto dto, @MappingTarget Director entity);
}
