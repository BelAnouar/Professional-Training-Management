package com.formation.formation.mapper;

import com.formation.formation.Entity.Apprenant;
import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formation;
import com.formation.formation.dto.request.ApprenantRequest;
import com.formation.formation.dto.response.ApprenantResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {})
public interface ApprenantMapper {

    @Mappings({
            @Mapping(target = "classe", source = "classeId", qualifiedByName = "toClasse"),
            @Mapping(target = "formation", source = "formationId", qualifiedByName = "toFormation")
    })
    Apprenant toEntity(ApprenantRequest request);

    @Named("toClasse")
    default Classe toClasse(Integer id) {
        if (id == null) return null;
        var classe = new Classe();
        classe.setId(id);
        return classe;
    }

    @Named("toFormation")
    default Formation toFormation(Integer id) {
        if (id == null) return null;
        var formation = new Formation();
        formation.setId(id);
        return formation;
    }
    @Mapping(source = "formation.id", target = "formationId")
    @Mapping(source = "classe.id", target = "classeId")
    ApprenantResponse toResponse(Apprenant apprenant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Apprenant entity, ApprenantRequest request);
}