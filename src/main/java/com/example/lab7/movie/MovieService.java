package com.example.lab7.movie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieDto create(MovieDto dto) {
        Movie entity = dto.toEntity();
        entity.setId(null);
        entity = repository.save(entity);
        return entity.toDto();
    }

    public MovieDto getById(Long id) {
        Movie entity = repository.findById(id).orElse(null);
        if (entity == null) return null;
        return entity.toDto();
    }

    public List<MovieDto> getAll() {
        List<Movie> entities = repository.findAll();
        List<MovieDto> result = new ArrayList<>();
        for (Movie m : entities) {
            result.add(m.toDto());
        }
        return result;
    }

    public MovieDto update(Long id, MovieDto dto) {
        Movie existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setTitle(dto.getTitle());
        existing.setAuthor(dto.getAuthor());
        existing.setYear(dto.getYear());
        return repository.save(existing).toDto();
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
