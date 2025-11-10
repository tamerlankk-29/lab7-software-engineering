package com.example.lab7.book;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookDto create(BookDto dto) {
        Book entity = dto.toEntity();
        entity.setId(null);
        entity = repository.save(entity);
        return entity.toDto();
    }

    public BookDto getById(Long id) {
        return repository.findById(id)
                .map(Book::toDto)
                .orElse(null);
    }

    public List<BookDto> getAll() {
        return repository.findAll().stream()
                .map(Book::toDto)
                .toList();
    }

    public BookDto update(Long id, BookDto dto) {
        Book existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found: " + id));
        existing.setTitle(dto.getTitle());
        existing.setAuthor(dto.getAuthor());
        existing.setYear(dto.getYear());
        existing.setIsbn(dto.getIsbn());
        return repository.save(existing).toDto();
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Book not found: " + id);
        }
        repository.deleteById(id);
    }
}
