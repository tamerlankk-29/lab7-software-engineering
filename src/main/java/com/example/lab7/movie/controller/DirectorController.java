package com.example.lab7.movie.controller;

import com.example.lab7.movie.dto.DirectorDto;
import com.example.lab7.movie.service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {
    private final DirectorService service;

    public DirectorController(DirectorService service) {
        this.service = service;
    }

    @PostMapping
    public DirectorDto create(@RequestBody DirectorDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<DirectorDto> getAll() {
        return service.getAll();
    }
}
