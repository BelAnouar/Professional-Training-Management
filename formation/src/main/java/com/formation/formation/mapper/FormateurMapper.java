package com.formation.formation.mapper;


import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formateur;

import com.formation.formation.Entity.Formation;
import com.formation.formation.dto.request.FormateurRequest;

import com.formation.formation.dto.response.FormateurResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {})
public interface FormateurMapper {

    @Mappings({
            @Mapping(target = "classe", source = "classe_id", qualifiedByName = "toClasse"),
            @Mapping(target = "formation", source = "formation_id", qualifiedByName = "toFormation")
    })
    Formateur toEntity(FormateurRequest request) ;

    @Mapping(source = "formation.id", target = "formation_id")
    @Mapping(source = "classe.id", target = "classe_id")
    FormateurResponse toResponse(Formateur formateur) ;

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
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget Formateur entity, FormateurRequest request);
}
