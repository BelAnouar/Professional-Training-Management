package com.formation.formation.controller;


import com.formation.formation.Entity.Apprenant;
import com.formation.formation.dto.request.ApprenantRequest;
import com.formation.formation.dto.response.ApprenantResponse;
import com.formation.formation.service.ApprenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/formation/apprenant")
@RequiredArgsConstructor
@Validated
public class ApprenantController {
    private  final ApprenantService apprenantService;

    @GetMapping
    public ResponseEntity<Page<ApprenantResponse>> getAllApprenants(@RequestParam(defaultValue = "0" ) int pageNo ,
                                                                    @RequestParam(defaultValue = "1") int pagesize) {
        Pageable pageable= PageRequest.of(pageNo, pagesize);

        return ResponseEntity.ok(apprenantService.getAllStudents(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprenantResponse> getApprenant(@PathVariable int id) {
        return ResponseEntity.ok(apprenantService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<ApprenantResponse> addApprenant(@Valid @RequestBody ApprenantRequest apprenant) {
        System.out.println(apprenant);
return ResponseEntity.status(HttpStatus.CREATED).body(apprenantService.createStudent(apprenant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApprenantResponse> updateApprenant( @PathVariable Integer id, @Valid @RequestBody ApprenantRequest apprenant) {
        return ResponseEntity.ok(apprenantService.updateStudent(id,apprenant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApprenantResponse> deleteApprenant(@PathVariable int id) {
        apprenantService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
