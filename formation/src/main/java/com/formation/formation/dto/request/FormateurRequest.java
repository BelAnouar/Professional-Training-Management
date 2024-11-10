package com.formation.formation.dto.request;



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
public class FormateurRequest {
    @NotBlank(message = "Le nom est obligatoire")
    private String name;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "L'email est obligatoire")
    private String email;
    @NotBlank(message = "La specialite est obligatoire")
    private String specialite;
    @NotNull(message = "L'ID de la formation est obligatoire")
    private Integer formation_id;

    @NotNull(message = "L'ID de la classe est obligatoire")
    private Integer classe_id;


}
