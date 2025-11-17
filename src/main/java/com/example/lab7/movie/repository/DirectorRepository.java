package com.example.lab7.movie.repository;

import com.example.lab7.movie.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
