package com.formation.formation.controller;


import com.formation.formation.Entity.Classe;
import com.formation.formation.dto.request.ClasseRequest;
import com.formation.formation.dto.response.ClasseResponse;
import com.formation.formation.service.ClasseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classe")
@RequiredArgsConstructor
@Validated
public class ClasseController {


    private final ClasseService classroomService;


    @PostMapping
    public ResponseEntity<ClasseResponse> createClassroom(
            @Valid @RequestBody ClasseRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(classroomService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseResponse> getClassroomById(
            @PathVariable Integer id) {
        return ResponseEntity.ok(classroomService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClasseResponse>> getAllClassrooms(
            @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize
    ) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return ResponseEntity.ok(classroomService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasseResponse> updateClassroom(
            @PathVariable Integer id,
            @Valid @RequestBody ClasseRequest request) {
        return ResponseEntity.ok(classroomService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Integer id) {
        classroomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
