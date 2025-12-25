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
                             @RequestParam Long user_id,
                             @RequestParam(required = false) Long id){

        Utilisateur utilisateur = utilisateurService.getUserById(user_id);
        Emprunt emprunt = (id != null) ? empruntService.findById(id) : new Emprunt();
        if(utilisateur != null){
            emprunt.setUtilisateur(utilisateur);
        }
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.setDateRetourPrevu(dateRetourPrevu);

        emprunt = empruntService.addEmprunt(emprunt);

        return "redirect:/emprunt/index";

    }

    @PostMapping("/delete")
    public String deleteEmprunt(@RequestParam Long id){
        Emprunt emprunt = empruntService.findById(id);

        emprunt = empruntService.deleteEmprunt(emprunt);

        return "redirect:/emprunt/index";
    }

    @GetMapping("/user/{id}")
    public String userEmpruntList(@PathVariable String id, Model model){

        Long longId = Long.parseLong(id);
        Utilisateur utilisateur = utilisateurService.getUserById(longId);

        List<Emprunt> emprunts = empruntService.findEmpruntByUser(utilisateur);

        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();

        model.addAttribute("emprunts", emprunts);
        model.addAttribute("utilisateurs", utilisateurs);

        return "";

    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Emprunt emprunt = empruntService.findById(id);
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();

        model.addAttribute("emprunt", emprunt);
        model.addAttribute("utilisateurs", utilisateurs);

        return "edit_emprunt";
    }



}
