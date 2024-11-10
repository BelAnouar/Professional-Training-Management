package com.formation.formation.integration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.formation.Entity.enums.StatutFormation;
import com.formation.formation.dto.request.FormationRequest;
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
public class FormationControllerTest {


    private final MockMvc mockMvc;
    private  final ObjectMapper objectMapper;
    private final FormationRepository formationRepository;



    @Test
    public  void  testListOfFormation()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/formation/formation")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

    }



    @Test
    public  void  testAddFormation()throws Exception{
        FormationRequest formationRequest =new FormationRequest("formation","niveau 2","xxx",12,32,"12-12-2003","12-12-2004", StatutFormation.EN_COURS);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/formation/formation").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(formationRequest))).andExpect(status().isCreated());
    }


}
