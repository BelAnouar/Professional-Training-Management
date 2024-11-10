package com.formation.formation.integration.service;



import com.formation.formation.FormationApplication;
import com.formation.formation.dto.response.ClasseResponse;
import com.formation.formation.service.impl.ClasseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ClassServiceImplTest {

    private final ClasseServiceImpl classeServiceImpl;

    @Autowired
    public ClassServiceImplTest(ClasseServiceImpl classeServiceImpl) {
        this.classeServiceImpl = classeServiceImpl;
    }


    @Test
    public void testListClasses() {
        final Page<ClasseResponse> classes= classeServiceImpl.findAll(PageRequest.of(0,10));

        assertThat(classes.getContent()).hasSize(0);
    }

    @Test
    public void testFindClassById() {

    }


    @Test
    public void testSaveClass() {


    }

}
