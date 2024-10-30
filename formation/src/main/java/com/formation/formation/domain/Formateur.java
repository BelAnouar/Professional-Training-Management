package com.formation.formation.domain;


import com.formation.formation.domain.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Formateur extends BaseEntity {
    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "formateur" )
    private List<Formation> formation;
    @OneToOne
    @JoinColumn(name = "Classe_id")
    private Classe classe;
}
