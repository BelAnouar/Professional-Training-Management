package com.formation.formation.controller;


import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.response.FormateurResponse;
import com.formation.formation.service.FormateurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/formation/formateur")
@RequiredArgsConstructor
public class FormateurController {


    private final FormateurService formateurService;


    @GetMapping
    public ResponseEntity<Page<FormateurResponse>>  getAllFormateurs(@RequestParam(defaultValue = "0") int pzgeNo ,@RequestParam(defaultValue = "10") int pafesize){
        Pageable pageable= PageRequest.of(pzgeNo,pafesize);
        return ResponseEntity.ok(formateurService.getAllFormateurs(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<FormateurResponse> getFormateur(@PathVariable int id){

        return ResponseEntity.ok(formateurService.getFormateur(id));
    }

    @PostMapping
    public ResponseEntity<FormateurResponse> createFormateur(@Valid @RequestBody FormateurRequest formateurRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(formateurService.createFormateur(formateurRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormateurResponse> updateFormateur(@PathVariable int id , @Valid @RequestBody FormateurRequest formateurRequest){
        return ResponseEntity.ok(formateurService.updateFormateur(id,formateurRequest));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<FormateurResponse> deleteFormateur(@PathVariable int id){
        formateurService.deleteFormateur(id);
        return ResponseEntity.noContent().build();
    }
}
