package com.formation.formation.mapper;


import com.formation.formation.Entity.Classe;
import com.formation.formation.dto.request.ClasseRequest;
import com.formation.formation.dto.response.ClasseResponse;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface ClasseMapper {



     Classe toEntity(ClasseRequest request);


    ClasseResponse toResponse(Classe classroom);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Classe entity, ClasseRequest request);

}
