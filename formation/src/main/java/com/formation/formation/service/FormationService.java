package com.formation.formation.service;

import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.request.FormationRequest;
import com.formation.formation.dto.response.FormateurResponse;
import com.formation.formation.dto.response.FormationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormationService {
    FormationResponse createFormation(FormationRequest request);
    FormationResponse getFormation(Integer id);
    Page<FormationResponse> getAllFormations(Pageable pageable);
    FormationResponse updateFormation(Integer id, FormationRequest request);
    void deleteFormation(Integer id);
}
