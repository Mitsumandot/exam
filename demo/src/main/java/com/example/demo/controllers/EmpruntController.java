package com.example.demo.controllers;


import com.example.demo.dao.entities.Emprunt;
import com.example.demo.dao.entities.Utilisateur;
import com.example.demo.dao.repositories.UtilisateurRepository;
import com.example.demo.services.EmpruntService;
import com.example.demo.services.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/emprunt")
public class EmpruntController {

    private final EmpruntService empruntService;

    private final UtilisateurService utilisateurService;

    public EmpruntController(EmpruntService empruntService, UtilisateurService utilisateurService){
        this.empruntService = empruntService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/index")
    public String listEmprunts(Model model){
        List<Emprunt> empruntList = empruntService.getAllEmprunts();

        model.addAttribute("emprunts", empruntList);

        LocalDate now = LocalDate.now();

        model.addAttribute("now", now);

        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();

        model.addAttribute("utilisateurs", utilisateurs);

        return "emprunts";

    }

    @PostMapping("/add")
    public String addEmprunt(@RequestParam LocalDate dateEmprunt,
                             @RequestParam LocalDate dateRetourPrevu,
                             @RequestParam Long user_id){


        Emprunt emprunt = new Emprunt();
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.setDateRetourPrevu(dateRetourPrevu);

        emprunt = empruntService.addEmprunt(emprunt);

        return "redirect:/emprunt/index";

    }



    @GetMapping("/user/{id}")
    public String userEmpruntList(@PathVariable String id, Model model){





        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();


        model.addAttribute("utilisateurs", utilisateurs);

        return "";

    }


}
