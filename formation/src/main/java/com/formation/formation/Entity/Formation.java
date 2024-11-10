package com.formation.formation.Entity;

import com.formation.formation.Entity.base.BaseEntity;
import com.formation.formation.Entity.enums.StatutFormation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Formation extends BaseEntity {
    private String titre;
    private String niveau;
    private String prerequis;
    private Integer capaciteMin;
    private Integer capaciteMax;
    private String dateDebut;
    private String dateFin;
    @OneToMany(mappedBy ="formation" )
    private List<Formateur> formateur;
    @OneToMany(mappedBy ="formation" )
    private List<Apprenant> apprenants;
    private StatutFormation statut;
}
