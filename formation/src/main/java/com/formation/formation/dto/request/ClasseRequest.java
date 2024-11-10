package com.formation.formation.dto.request;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseRequest {

    @NotBlank(message = "Le nom est obligatoire")
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ0-9\\s-]{2,50}$",
            message = "Le nom doit contenir entre 2 et 50 caractères et peut contenir des lettres, chiffres, espaces et tirets"
    )
    private String name;
    @NotNull(message = "Room number is required")
    @Min(value = 1, message = "Room number must be at least 1")
    private Integer roomNumber;
}
