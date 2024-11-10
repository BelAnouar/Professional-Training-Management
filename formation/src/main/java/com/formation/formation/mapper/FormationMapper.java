package com.formation.formation.mapper;



import com.formation.formation.Entity.Formation;

import com.formation.formation.dto.request.FormationRequest;
import com.formation.formation.dto.response.FormationResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FormationMapper {


    Formation toEntity(FormationRequest formationRequest);

    FormationResponse toResponse(Formation formation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Formation entity, FormationRequest request);

}
