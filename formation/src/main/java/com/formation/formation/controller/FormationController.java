package com.formation.formation.controller;

import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.request.FormationRequest;
import com.formation.formation.dto.response.ClasseResponse;
import com.formation.formation.dto.response.FormationResponse;
import com.formation.formation.service.FormationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/formation/formation")
@RequiredArgsConstructor
public class FormationController {


    private final FormationService formationService;

    @GetMapping
    public ResponseEntity<Page<FormationResponse>> getAllFormations(@RequestParam(defaultValue = "0") int pageNo ,@RequestParam(defaultValue = "10") int pigeSize){
        Pageable pageable = PageRequest.of(pageNo,pigeSize);

        return ResponseEntity.ok(formationService.getAllFormations(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<FormationResponse> getFormationById(@PathVariable("id") int id){
        return ResponseEntity.ok(formationService.getFormation(id));
    }
    @PostMapping ResponseEntity<FormationResponse> createFormation(@Valid @RequestBody FormationRequest formationRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(formationService.createFormation(formationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationResponse> updateFormation(@PathVariable int id, @Valid @RequestBody FormationRequest formateurRequest){
      return   ResponseEntity.ok(formationService.updateFormation(id,formateurRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FormationResponse> deleteFormation(@PathVariable int id){
        formationService.deleteFormation(id);
        return ResponseEntity.ok().build();
    }

}
