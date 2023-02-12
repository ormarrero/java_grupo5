package com.example.repository;

import com.example.entities.Taller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TallerRepository extends JpaRepository<Taller, Long> {
}