package com.formation.formation.service.impl;

import com.formation.formation.Entity.Classe;
import com.formation.formation.dto.request.ClasseRequest;
import com.formation.formation.dto.response.ClasseResponse;
import com.formation.formation.exception.ResourceNotFoundException;
import com.formation.formation.mapper.ClasseMapper;
import com.formation.formation.repository.ClasseRepository;
import com.formation.formation.service.ClasseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;
    private final ClasseMapper classeMapper;


    @Transactional
    public ClasseResponse create(ClasseRequest request) {



        if (classeRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Une classe avec ce nom existe déjà");
        }

        Classe classe = classeMapper.toEntity(request);

        Classe savedClassroom = classeRepository.save(classe);

        log.info("Nouvelle classe créée : {}", savedClassroom.getName());
        return classeMapper.toResponse(savedClassroom);
    }

    @Transactional(readOnly = true)
    public ClasseResponse findById(Integer id) {
        return classeRepository.findById(id)
                .map(classeMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Classe non trouvée avec l'ID : " + id));
    }

    @Transactional(readOnly = true)
    public Page<ClasseResponse> findAll(Pageable pageable) {
        return classeRepository.findAll(pageable)
                .map(classeMapper::toResponse);
    }

    @Transactional
    public ClasseResponse update(Integer id, ClasseRequest request) {
        Classe existingClassroom = classeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classe non trouvée avec l'ID : " + id));

        classeMapper.updateEntity(existingClassroom, request);
        Classe updatedClassroom = classeRepository.save(existingClassroom);

        log.info("Classe mise à jour : {}", updatedClassroom.getName());
        return classeMapper.toResponse(updatedClassroom);
    }

    @Transactional
    public void delete(Integer id) {
        Classe classroom = classeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classe non trouvée avec l'ID : " + id));

        classeRepository.delete(classroom);
        log.info("Classe supprimée : {}", classroom.getName());
    }

    @Transactional(readOnly = true)
    public List<ClasseResponse> findClassroomsWithMoreThanStudents(Integer threshold) {
        return classeRepository.findClassroomsWithMoreThanStudents(threshold)
                .stream()
                .map(classeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
