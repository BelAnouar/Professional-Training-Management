package com.formation.formation.dto.response;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormateurResponse {
    private Integer id;
    private String name;
    private String prenom;
    private String email;
    private String specialite;
    private Integer formation_id;
    private Integer classe_id;
}
