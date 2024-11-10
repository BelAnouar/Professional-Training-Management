package com.formation.formation.Entity;


import com.formation.formation.Entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
public class Formateur extends BaseEntity {
    private String name;
    private String prenom;
    private String email;
    private String specialite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formation_id")
    private Formation formation;
    @OneToOne
    @JoinColumn(name = "Classe_id")
    private Classe classe;
}
