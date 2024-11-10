package com.formation.formation.dto.response;


import com.formation.formation.Entity.enums.StatutFormation;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormationResponse {
    private Integer id;
    private String titre;
    private String niveau;
    private String prerequis;
    private Integer capaciteMin;
    private Integer capaciteMax;
    private String dateDebut;
    private String dateFin;
    private List<FormateurResponse> formateurs;
    private List<ApprenantResponse> apprenants;
    private StatutFormation statut;
}
