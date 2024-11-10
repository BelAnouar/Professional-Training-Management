package com.formation.formation.integration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.formation.Entity.Apprenant;
import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formation;
import com.formation.formation.Entity.enums.StatutFormation;
import com.formation.formation.dto.request.ApprenantRequest;
import com.formation.formation.repository.ApprenantRepository;
import com.formation.formation.repository.ClasseRepository;
import com.formation.formation.repository.FormationRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ExtendWith(SpringExtension.class)
public class ApprenantControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final ApprenantRepository apprenantRepository;
    private final ClasseRepository classeRepository;
    private final FormationRepository formationRepository;
    @Test
    public void testFindAllApprenants() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/formation/apprenant")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    @Test
    public void testFindOneApprenant() throws Exception {
        Apprenant apprenant = apprenantRepository.save(new Apprenant("exampleName","exampleLastName","exampleEmail@gmail.Col","Basic",null,null));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/formation/apprenant/"+apprenant.getId())).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }
    @Test
    public void testSaveApprenant() throws Exception {
        Classe classe = classeRepository.save( new Classe("Classe 1A",21,null,null));
        Formation formation= formationRepository.save( new Formation("formation","niveau 2","xxx",12,32,"12-12-2003","12-12-2004",null,null, StatutFormation.EN_COURS));
        ApprenantRequest apprenantRequest =new ApprenantRequest("exampleName","exampleLastName","exampleEmail@gmail.Col","AVANCE",formation.getId(),classe.getId() );
        mockMvc.perform(MockMvcRequestBuilders.post("/api/formation/apprenant").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(apprenantRequest))).andDo(MockMvcResultHandlers.print()).andExpect(status().isCreated());
    }
    @Test
    public void testDeleteApprenant() throws Exception {
        Apprenant apprenant = apprenantRepository.save(new Apprenant("exampleName","exampleLastName","exampleEmail@gmail.Col","Basic",null,null));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/formation/apprenant"+apprenant.getId()));

    }
}
