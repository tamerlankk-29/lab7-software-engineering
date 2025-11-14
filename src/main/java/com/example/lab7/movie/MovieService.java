package com.example.lab7.movie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        return repository.findById(id)
                .map(Movie::toDto)
                .orElse(null);
    }

    public List<MovieDto> getAll() {
        return repository.findAll().stream()
                .map(Movie::toDto)
                .toList();
    }

    public MovieDto update(Long id, MovieDto dto) {
        Movie existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movie not found: " + id));
        existing.setTitle(dto.getTitle());
        existing.setAuthor(dto.getAuthor());
        existing.setYear(dto.getYear());
        return repository.save(existing).toDto();
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Movie not found: " + id);
        }
        repository.deleteById(id);
    }
}
