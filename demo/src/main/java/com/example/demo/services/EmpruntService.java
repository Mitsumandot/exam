package com.example.demo.services;

import com.example.demo.dao.entities.Emprunt;
import com.example.demo.dao.entities.Utilisateur;
import com.example.demo.dao.repositories.EmpruntRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService implements IEmpruntService {

    private final EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository){
        this.empruntRepository = empruntRepository;
    }


    @Override
    public Emprunt addEmprunt(Emprunt emprunt) {
        Optional<Emprunt> optionalEmprunt = empruntRepository.findById(emprunt.getId());
        if(optionalEmprunt.isPresent()){
            return emprunt;
        }
        return empruntRepository.save(emprunt);
    }

    @Override
    public List<Emprunt> findEmpruntByUser(Utilisateur utilisateur) {
        return empruntRepository.findByUtilisateur(utilisateur);
    }

    public Emprunt deleteEmprunt(Emprunt emprunt){
        empruntRepository.delete(emprunt);
        return emprunt;
    }

    public List<Emprunt> getAllEmprunts(){
        return empruntRepository.findAll();
    }

   
}
