package com.example.lab7.movie.service;

import com.example.lab7.movie.dto.DirectorDto;
import com.example.lab7.movie.entity.Director;
import com.example.lab7.movie.mapper.DirectorMapper;
import com.example.lab7.movie.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {
    private final DirectorRepository repository;
    private final DirectorMapper mapper;

    public DirectorService(DirectorRepository repository, DirectorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DirectorDto create(DirectorDto dto) {
        Director entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public List<DirectorDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
