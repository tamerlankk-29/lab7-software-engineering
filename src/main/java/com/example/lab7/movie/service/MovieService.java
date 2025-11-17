package com.example.lab7.movie.service;

import com.example.lab7.movie.dto.MovieReadDto;
import com.example.lab7.movie.dto.MovieWriteDto;
import com.example.lab7.movie.entity.Movie;
import com.example.lab7.movie.mapper.MovieMapper;
import com.example.lab7.movie.mapper.MovieWriteMapper;
import com.example.lab7.movie.repository.DirectorRepository;
import com.example.lab7.movie.repository.MovieRepository;
import com.example.lab7.movie.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {
    private final MovieRepository repository;
    private final DirectorRepository directorRepository;
    private final TagRepository tagRepository;
    private final MovieMapper movieMapper;
    private final MovieWriteMapper movieWriteMapper;

    public MovieService(MovieRepository repository,
                        DirectorRepository directorRepository,
                        TagRepository tagRepository,
                        MovieMapper movieMapper,
                        MovieWriteMapper movieWriteMapper) {
        this.repository = repository;
        this.directorRepository = directorRepository;
        this.tagRepository = tagRepository;
        this.movieMapper = movieMapper;
        this.movieWriteMapper = movieWriteMapper;
    }

    public MovieReadDto create(MovieWriteDto dto) {
        Movie entity = movieWriteMapper.toEntity(dto, directorRepository, tagRepository);
        entity.setId(null);
        entity = repository.save(entity);
        return movieMapper.toReadDto(entity);
    }

    @Transactional(readOnly = true)
    public MovieReadDto getById(Long id) {
        Movie entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        return movieMapper.toReadDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MovieReadDto> getAll() {
        return repository.findAll().stream()
                .map(movieMapper::toReadDto)
                .collect(Collectors.toList());
    }

    public MovieReadDto update(Long id, MovieWriteDto dto) {
        Movie existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        movieWriteMapper.updateEntity(dto, existing, directorRepository, tagRepository);
        return movieMapper.toReadDto(repository.save(existing));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
