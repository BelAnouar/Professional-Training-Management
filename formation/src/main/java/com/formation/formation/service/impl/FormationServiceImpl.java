package com.formation.formation.service.impl;

import com.formation.formation.Entity.Formation;
import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.request.FormationRequest;
import com.formation.formation.dto.response.FormationResponse;
import com.formation.formation.exception.ResourceNotFoundException;
import com.formation.formation.mapper.FormateurMapper;
import com.formation.formation.mapper.FormationMapper;
import com.formation.formation.repository.FormationRepository;
import com.formation.formation.service.FormationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {
    private final FormationRepository formationRepository;
    private final FormationMapper formationMapper;
    @Override
    public FormationResponse createFormation(FormationRequest request) {

        log.info("creating formation");
        Formation formation= formationMapper.toEntity(request);
        Formation savedFormation= formationRepository.save(formation);
        log.info("saved formation");
        return formationMapper.toResponse(savedFormation);
    }

    @Override
    public FormationResponse getFormation(Integer id) {
        return formationRepository.findById(id).map(formationMapper::toResponse).orElse(null);
    }

    @Override
    public Page<FormationResponse> getAllFormations(Pageable pageable) {
        return formationRepository.findAll(pageable).map(formationMapper::toResponse);
    }

    @Override
    public FormationResponse updateFormation(Integer id, FormationRequest request) {
      Formation formation=formationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Formation "+id+" not found"));
      formationMapper.updateEntity(formation,request);
      Formation savedFormation= formationRepository.save(formation);
      log.info("saved formation");
      return formationMapper.toResponse(savedFormation);
    }

    @Override
    public void deleteFormation(Integer id) {
Formation formation = formationRepository.findById(id).orElseThrow(()->new  ResourceNotFoundException("Formation "+id+" not found"));
formationRepository.delete(formation);
    }
}
