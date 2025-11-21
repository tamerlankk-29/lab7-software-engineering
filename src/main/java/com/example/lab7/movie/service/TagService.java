package com.example.lab7.movie.service;

import com.example.lab7.movie.dto.TagDto;
import com.example.lab7.movie.entity.Tag;
import com.example.lab7.movie.mapper.TagMapper;
import com.example.lab7.movie.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {
    private final TagRepository repository;
    private final TagMapper mapper;

    public TagService(TagRepository repository, TagMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TagDto create(TagDto dto) {
        Tag entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    public List<TagDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public TagDto getById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    public TagDto update(Long id, TagDto dto) {
        Tag existing = repository.findById(id).orElse(null);
        if (existing == null) return null;
        mapper.updateEntity(dto, existing);
        return mapper.toDto(repository.save(existing));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
