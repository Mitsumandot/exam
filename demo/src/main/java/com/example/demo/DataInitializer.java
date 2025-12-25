package com.example.demo;

import com.example.demo.dao.entities.Emprunt;
import com.example.demo.dao.entities.Utilisateur;
import com.example.demo.services.EmpruntService;
import com.example.demo.services.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UtilisateurService utilisateurService;
    private final EmpruntService empruntService;

    public DataInitializer(UtilisateurService utilisateurService,
                           EmpruntService empruntService) {
        this.utilisateurService = utilisateurService;
        this.empruntService = empruntService;
    }

    @Override
    public void run(String... args) {

        Utilisateur user = new Utilisateur();
        user.setNom("Othmane");
        user.setEmail("othmane@test.com");
        user.setPrenom("othmane");
        user = utilisateurService.save(user);


        Emprunt emprunt = new Emprunt();
        emprunt.setDateEmprunt(LocalDate.now());
        emprunt.setDateRetourPrevu(LocalDate.now().plusDays(14));
        emprunt.setUtilisateur(user);

        empruntService.addEmprunt(emprunt);

        System.out.println("User + Emprunt created at startup ✅");
    }
}

