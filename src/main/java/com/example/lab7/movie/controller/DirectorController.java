package com.example.lab7.movie.controller;

import com.example.lab7.movie.dto.DirectorDto;
import com.example.lab7.movie.service.DirectorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {
    private final DirectorService service;

    public DirectorController(DirectorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DirectorDto> create(@RequestBody DirectorDto dto, UriComponentsBuilder uriBuilder) {
        DirectorDto created = service.create(dto);
        URI location = uriBuilder.path("/api/directors/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public List<DirectorDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getById(@PathVariable Long id) {
        DirectorDto dto = service.getById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDto> update(@PathVariable Long id, @RequestBody DirectorDto dto) {
        DirectorDto updated = service.update(id, dto);
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
