package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}
