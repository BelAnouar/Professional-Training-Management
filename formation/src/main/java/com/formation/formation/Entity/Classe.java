package com.formation.formation.Entity;


import com.formation.formation.Entity.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Classe extends BaseEntity {
    @Column(name = "name")
    private String name;
    private Integer roomNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Apprenant> apprenant;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Formateur> formateur;

}
