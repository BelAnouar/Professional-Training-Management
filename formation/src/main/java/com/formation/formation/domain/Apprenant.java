package com.formation.formation.domain;


import com.formation.formation.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Apprenant extends BaseEntity {
    private String nom;
    private String prenom;
    private String email;
    private String niveau;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apprenant_id")
    private Formation formation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe_id")
    private Classe classe;
}
