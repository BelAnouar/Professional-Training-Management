package com.formation.formation.service.impl;


import com.formation.formation.Entity.Apprenant;
import com.formation.formation.dto.request.ApprenantRequest;
import com.formation.formation.dto.response.ApprenantResponse;
import com.formation.formation.exception.ResourceNotFoundException;
import com.formation.formation.mapper.ApprenantMapper;
import com.formation.formation.repository.ApprenantRepository;
import com.formation.formation.service.ApprenantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class ApprenantServiceImpl implements ApprenantService {

    private final ApprenantRepository apprenantRepository;
    private final ApprenantMapper apprenantMapper;


    @Override
    @Transactional
    public ApprenantResponse createStudent(ApprenantRequest request) {
        log.debug("Creating student with request: {}", request);
System.out.println(request);
        if (apprenantRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + request.getEmail());
        }

        Apprenant apprenant = apprenantMapper.toEntity(request);
        System.out.println(apprenant);
       Apprenant apprenantsave = apprenantRepository.save(apprenant);
        return apprenantMapper.toResponse(apprenantsave);
    }

    @Override
    @Transactional(readOnly = true)
    public ApprenantResponse getStudent(Integer id) {
        log.debug("Getting student with id: {}", id);

        Apprenant student = apprenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return apprenantMapper.toResponse(student);
    }

    @Override
    public Page<ApprenantResponse> getAllStudents(Pageable pageable) {
        return apprenantRepository.findAll(pageable).map(apprenantMapper::toResponse);
    }

    @Override
    public ApprenantResponse updateStudent(Integer id, ApprenantRequest request) {
        Apprenant apprenant=apprenantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        apprenantMapper.updateEntity(apprenant, request);
        Apprenant updated=apprenantRepository.save(apprenant);

        return apprenantMapper.toResponse(updated);
    }

    @Override
    public void deleteStudent(Integer id) {
       Apprenant apprenant=apprenantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
       apprenantRepository.delete(apprenant);

    }
}
