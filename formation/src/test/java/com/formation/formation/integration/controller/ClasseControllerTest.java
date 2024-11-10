package com.formation.formation.integration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.formation.Entity.Classe;
import com.formation.formation.dto.request.ClasseRequest;
import com.formation.formation.repository.ClasseRepository;
import com.formation.formation.service.ClasseService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ExtendWith(SpringExtension.class)
public class ClasseControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final ClasseRepository classeRepository;

    @Test
    public void  testListClassesWithTotal() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.get("/api/classe")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").value(0));
    }

    @Test
    public void  testAddClasses() throws Exception {
        ClasseRequest classe = new ClasseRequest("Classe 1A",21);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/classe").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(classe))
                        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    public void  testDeleteClasses() throws Exception {

        Classe classe = classeRepository.save( new Classe("Classe 1A",21,null,null));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/classe/" + classe.getId()));
        assertFalse(classeRepository.existsById(classe.getId()));
    }


}
