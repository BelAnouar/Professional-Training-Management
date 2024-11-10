package com.formation.formation.service.impl;

import com.formation.formation.Entity.Formateur;
import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.response.FormateurResponse;
import com.formation.formation.exception.ResourceNotFoundException;
import com.formation.formation.mapper.FormateurMapper;
import com.formation.formation.repository.FormateurRepository;
import com.formation.formation.service.FormateurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;
    private final FormateurMapper formateurMapper;
    @Override
    public FormateurResponse createFormateur(FormateurRequest request) {
        log.info("creating formateur");
        Formateur formateur= formateurMapper.toEntity(request);
        Formateur savedFormateur = formateurRepository.save(formateur);
        log.info("formateur created");
        return formateurMapper.toResponse(savedFormateur);
    }

    @Override
    public FormateurResponse getFormateur(Integer id) {
        return formateurRepository.findById(id).map(formateurMapper::toResponse).orElse(null);
    }

    @Override
    public Page<FormateurResponse> getAllFormateurs(Pageable pageable) {

        return formateurRepository.findAll(pageable).map(formateurMapper::toResponse);
    }

    @Override
    public FormateurResponse updateFormateur(Integer id, FormateurRequest request) {
        Formateur formateur= formateurRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("formateur doesn't exist"));
        formateurMapper.updateEntity(formateur,request);
        Formateur savedFormateur = formateurRepository.save(formateur);
        log.info("formateur updated");

        return formateurMapper.toResponse(savedFormateur);
    }

    @Override
    public void deleteFormateur(Integer id) {
Formateur formateur=formateurRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("formateur doesn't exist"));
formateurRepository.delete(formateur);
    }
}
