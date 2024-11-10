package com.formation.formation.integration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formateur;
import com.formation.formation.Entity.Formation;
import com.formation.formation.Entity.enums.StatutFormation;
import com.formation.formation.controller.FormateurController;
import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.request.FormationRequest;
import com.formation.formation.repository.ClasseRepository;
import com.formation.formation.repository.FormateurRepository;
import com.formation.formation.repository.FormationRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
public class FormateurControllerTest {

    private final MockMvc mvc;
    private final ObjectMapper mapper;
    private final FormateurRepository repository;
    private final ClasseRepository classeRepository;
    private final FormationRepository formationRepository;

    @Test
    public void testfindAllFormateur() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/formation/formateur")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    @Test
    public  void  testAddFormateur() throws Exception {
        Classe classe = classeRepository.save( new Classe("Classe 1A",21,null,null));
        Formation formation= formationRepository.save( new Formation("formation","niveau 2","xxx",12,32,"12-12-2003","12-12-2004",null,null, StatutFormation.EN_COURS));
        FormateurRequest formateurRequest =new FormateurRequest("Adbo","Nano","example@gmail.com","info",formation.getId(),classe.getId() );
        mvc.perform(MockMvcRequestBuilders.post("/api/formation/formateur").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(formateurRequest))).andExpect(status().isCreated());
    }

    @Test
    public void testFindFormateurById() throws Exception {
        Formateur formateur = repository.save( new Formateur("exampleName","exampleLastName","exampleEmail@gmail.Col","info",null,null));
        mvc.perform(MockMvcRequestBuilders.get("/api/formation/formateur/"+formateur.getId())).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    @Test
    public void testDeleteFormateurById() throws Exception {
        Formateur formateur = repository.save( new Formateur("exampleName","exampleLastName","exampleEmail@gmail.Col","info",null,null));
        mvc.perform(MockMvcRequestBuilders.delete( "/api/formation/formateur/"+formateur.getId() ));
    }
}
