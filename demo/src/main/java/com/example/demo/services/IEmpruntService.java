package com.example.demo.services;

import com.example.demo.dao.entities.Emprunt;
import com.example.demo.dao.entities.Utilisateur;
import com.example.demo.dao.repositories.EmpruntRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmpruntService {
    Emprunt addEmprunt(Emprunt emprunt);

    List<Emprunt> findEmpruntByUser(Utilisateur utilisateur);
}
