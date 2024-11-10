package com.formation.formation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApprenantResponse {
    private Integer id;
    private String name;
    private String prenom;
    private String email;
    private String niveau;
    private Integer formationId;
    private Integer classeId;
}   