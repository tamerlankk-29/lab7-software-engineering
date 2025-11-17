package com.example.lab7.movie.repository;

import com.example.lab7.movie.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
