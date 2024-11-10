package com.formation.formation.dto.response;



import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClasseResponse {
    private Integer id;
    private String name;
    private Integer roomNumber;
    private List<ApprenantResponse> apprenants;
    private List<FormateurResponse> formateurs;

}
