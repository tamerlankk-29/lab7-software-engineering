package com.example.lab7.movie.controller;

import com.example.lab7.movie.dto.MovieReadDto;
import com.example.lab7.movie.dto.MovieWriteDto;
import com.example.lab7.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public MovieReadDto create(@RequestBody MovieWriteDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieReadDto> getById(@PathVariable Long id) {
        MovieReadDto dto = service.getById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<MovieReadDto> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieReadDto> update(@PathVariable Long id, @RequestBody MovieWriteDto dto) {
        MovieReadDto updated = service.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
