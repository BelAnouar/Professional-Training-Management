package com.formation.formation.dto.request;


import com.formation.formation.Entity.Apprenant;
import com.formation.formation.Entity.Formateur;
import com.formation.formation.Entity.enums.StatutFormation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormationRequest {
    @NotBlank(message = "Le name est obligatoire")
    private String titre;
    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;
    @NotBlank(message = "Le prerequis est obligatoire ")
    private String prerequis;
    @NotNull(message = "La capacite Min est obligatoire")
    @Min(value = 1, message = "La capacité minimum doit être au moins 1")
    private Integer capaciteMin;
    @NotNull(message = "La capacite Max est obligatoire")
    @Min(value = 1, message = "La capacité max doit être au moins 1")
    private Integer capaciteMax;
    @NotBlank(message = "La date debut est obligatoire")
    private String dateDebut;
    @NotBlank(message = "La date fin est obligatoire")
    private String dateFin;
    @NotNull(message = "Le statut est obligatoire")
    private StatutFormation statut;
}