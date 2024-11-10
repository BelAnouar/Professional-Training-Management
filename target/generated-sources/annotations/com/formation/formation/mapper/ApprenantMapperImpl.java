package com.formation.formation.mapper;

import com.formation.formation.Entity.Apprenant;
import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formation;
import com.formation.formation.dto.request.ApprenantRequest;
import com.formation.formation.dto.response.ApprenantResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-09T00:46:34+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ApprenantMapperImpl implements ApprenantMapper {

    @Override
    public Apprenant toEntity(ApprenantRequest request) {
        if ( request == null ) {
            return null;
        }

        Apprenant.ApprenantBuilder apprenant = Apprenant.builder();

        apprenant.classe( toClasse( request.getClasseId() ) );
        apprenant.formation( toFormation( request.getFormationId() ) );
        apprenant.name( request.getName() );
        apprenant.prenom( request.getPrenom() );
        apprenant.email( request.getEmail() );
        apprenant.niveau( request.getNiveau() );

        return apprenant.build();
    }

    @Override
    public ApprenantResponse toResponse(Apprenant apprenant) {
        if ( apprenant == null ) {
            return null;
        }

        ApprenantResponse.ApprenantResponseBuilder apprenantResponse = ApprenantResponse.builder();

        apprenantResponse.formationId( apprenantFormationId( apprenant ) );
        apprenantResponse.classeId( apprenantClasseId( apprenant ) );
        apprenantResponse.id( apprenant.getId() );
        apprenantResponse.name( apprenant.getName() );
        apprenantResponse.prenom( apprenant.getPrenom() );
        apprenantResponse.email( apprenant.getEmail() );
        apprenantResponse.niveau( apprenant.getNiveau() );

        return apprenantResponse.build();
    }

    @Override
    public void updateEntity(Apprenant entity, ApprenantRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            entity.setName( request.getName() );
        }
        if ( request.getPrenom() != null ) {
            entity.setPrenom( request.getPrenom() );
        }
        if ( request.getEmail() != null ) {
            entity.setEmail( request.getEmail() );
        }
        if ( request.getNiveau() != null ) {
            entity.setNiveau( request.getNiveau() );
        }
    }

    private Integer apprenantFormationId(Apprenant apprenant) {
        if ( apprenant == null ) {
            return null;
        }
        Formation formation = apprenant.getFormation();
        if ( formation == null ) {
            return null;
        }
        Integer id = formation.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer apprenantClasseId(Apprenant apprenant) {
        if ( apprenant == null ) {
            return null;
        }
        Classe classe = apprenant.getClasse();
        if ( classe == null ) {
            return null;
        }
        Integer id = classe.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
