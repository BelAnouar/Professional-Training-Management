package com.formation.formation.Entity;


import com.formation.formation.Entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Classe extends BaseEntity {
    private String nom;
    private int numSalle;
    @OneToMany
    private List<Apprenant> apprenant;
    @OneToMany
    private  List<Formateur> formateur;
}
