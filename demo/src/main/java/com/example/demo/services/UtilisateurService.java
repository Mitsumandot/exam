package com.example.demo.services;

import com.example.demo.dao.entities.Utilisateur;
import com.example.demo.dao.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;


    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }



    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur save(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
}
