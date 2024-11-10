package com.formation.formation.service;


import com.formation.formation.dto.request.ApprenantRequest;
import com.formation.formation.dto.response.ApprenantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApprenantService {
    ApprenantResponse createStudent(ApprenantRequest request);
    ApprenantResponse getStudent(Integer id);
    Page<ApprenantResponse> getAllStudents(Pageable pageable);
    ApprenantResponse updateStudent(Integer id, ApprenantRequest request);
    void deleteStudent(Integer id);

}
