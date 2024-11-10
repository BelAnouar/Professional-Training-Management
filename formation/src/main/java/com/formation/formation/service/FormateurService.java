package com.formation.formation.service;


import com.formation.formation.dto.request.FormateurRequest;

import com.formation.formation.dto.response.FormateurResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormateurService {

    FormateurResponse createFormateur(FormateurRequest request);
    FormateurResponse getFormateur(Integer id);
    Page<FormateurResponse> getAllFormateurs(Pageable pageable);
    FormateurResponse updateFormateur(Integer id, FormateurRequest request);
    void deleteFormateur(Integer id);
}
