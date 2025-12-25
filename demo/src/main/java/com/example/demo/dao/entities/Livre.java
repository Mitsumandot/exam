package com.example.demo.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titre;

    private String auteur;

    private Date datePublication;

    private String status;

    private int isbn;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    Utilisateur utilisateur;

    @OneToMany(mappedBy = "livre")
    private List<Emprunt> emprunts;
}
