package com.formation.formation.dto.request;


import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formation;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApprenantRequest {

    @NotBlank(message = "Le prénom est obligatoire")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s-]{2,50}$",
            message = "Le prénom doit contenir entre 2 et 50 caractères et ne peut contenir que des lettres, espaces et tirets")
    private String name;

    @NotBlank(message = "Le nom est obligatoire")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s-]{2,50}$",
            message = "Le nom doit contenir entre 2 et 50 caractères et ne peut contenir que des lettres, espaces et tirets")
    private String prenom;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String email;

    @NotBlank(message = "Le niveau est obligatoire")
    @Pattern(regexp = "^(DEBUTANT|INTERMEDIAIRE|AVANCE)$",
            message = "Le niveau doit être DEBUTANT, INTERMEDIAIRE ou AVANCE")
    private String niveau;

    @NotNull(message = "L'ID de la formation est obligatoire")
    private Integer formationId;

    @NotNull(message = "L'ID de la classe est obligatoire")
    private Integer classeId;
}