package com.example.lab7.movie.mapper;

import com.example.lab7.movie.dto.TagDto;
import com.example.lab7.movie.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDto toDto(Tag entity);
    Tag toEntity(TagDto dto);
    void updateEntity(TagDto dto, @MappingTarget Tag entity);
}
