package com.example.lab7.movie.controller;

import com.example.lab7.movie.dto.TagDto;
import com.example.lab7.movie.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @PostMapping
    public TagDto create(@RequestBody TagDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<TagDto> getAll() {
        return service.getAll();
    }
}
