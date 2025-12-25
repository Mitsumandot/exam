package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Emprunt;
import com.example.demo.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

    List<Emprunt> findByUtilisateur(Utilisateur utilisateur);

}
