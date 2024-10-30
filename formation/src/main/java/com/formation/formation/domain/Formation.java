package com.formation.formation.domain;

import com.formation.formation.domain.base.BaseEntity;
import com.formation.formation.domain.enums.StatutFormation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formation extends BaseEntity {
    private String titre;
    private String niveau;
    private String prerequis;
    private int capaciteMin;
    private int capaciteMax;
    private String dateDebut;
    private String dateFin;
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
    @OneToMany(mappedBy ="formation" )
    private List<Apprenant> apprenants;
    private StatutFormation statut;
}
