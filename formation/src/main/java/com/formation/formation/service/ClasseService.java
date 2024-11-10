package com.formation.formation.service;

import com.formation.formation.Entity.Classe;
import com.formation.formation.dto.request.ClasseRequest;
import com.formation.formation.dto.response.ClasseResponse;
import com.formation.formation.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface ClasseService {



     ClasseResponse create(ClasseRequest request);




     ClasseResponse findById(Integer id) ;


     Page<ClasseResponse> findAll(Pageable pageable);


     ClasseResponse update(Integer id, ClasseRequest request) ;


     void delete(Integer id) ;

     List<ClasseResponse> findClassroomsWithMoreThanStudents(Integer threshold) ;
}
