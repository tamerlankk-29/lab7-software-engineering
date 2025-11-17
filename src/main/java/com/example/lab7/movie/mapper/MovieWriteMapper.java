package com.example.lab7.movie.mapper;

import com.example.lab7.movie.entity.Movie;
import com.example.lab7.movie.dto.MovieWriteDto;
import com.example.lab7.movie.entity.Director;
import com.example.lab7.movie.entity.Tag;
import com.example.lab7.movie.repository.DirectorRepository;
import com.example.lab7.movie.repository.TagRepository;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieWriteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "director", expression = "java(resolveDirector(dto.getDirectorId(), directorRepository))")
    @Mapping(target = "tags", expression = "java(resolveTags(dto.getTagIds(), tagRepository))")
    Movie toEntity(MovieWriteDto dto,
                   @Context DirectorRepository directorRepository,
                   @Context TagRepository tagRepository);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "director", expression = "java(resolveDirector(dto.getDirectorId(), directorRepository))")
    @Mapping(target = "tags", expression = "java(resolveTags(dto.getTagIds(), tagRepository))")
    void updateEntity(MovieWriteDto dto,
                      @MappingTarget Movie entity,
                      @Context DirectorRepository directorRepository,
                      @Context TagRepository tagRepository);

    default Director resolveDirector(Long id, @Context DirectorRepository repo) {
        if (id == null) return null;
        return repo.findById(id).orElse(null);
    }

    default Set<Tag> resolveTags(List<Long> ids, @Context TagRepository repo) {
        if (ids == null) return new HashSet<>();
        return new HashSet<>(repo.findAllById(ids));
    }
}
