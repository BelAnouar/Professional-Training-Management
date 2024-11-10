package com.formation.formation.mapper;

import com.formation.formation.Entity.Classe;
import com.formation.formation.Entity.Formateur;
import com.formation.formation.Entity.Formation;
import com.formation.formation.dto.request.FormateurRequest;
import com.formation.formation.dto.response.FormateurResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-09T11:57:01+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FormateurMapperImpl implements FormateurMapper {

    @Override
    public Formateur toEntity(FormateurRequest request) {
        if ( request == null ) {
            return null;
        }

        Formateur.FormateurBuilder formateur = Formateur.builder();

        formateur.classe( toClasse( request.getClasse_id() ) );
        formateur.formation( toFormation( request.getFormation_id() ) );
        formateur.name( request.getName() );
        formateur.prenom( request.getPrenom() );
        formateur.email( request.getEmail() );
        formateur.specialite( request.getSpecialite() );

        return formateur.build();
    }

    @Override
    public FormateurResponse toResponse(Formateur formateur) {
        if ( formateur == null ) {
            return null;
        }

        FormateurResponse.FormateurResponseBuilder formateurResponse = FormateurResponse.builder();

        formateurResponse.formation_id( formateurFormationId( formateur ) );
        formateurResponse.classe_id( formateurClasseId( formateur ) );
        formateurResponse.id( formateur.getId() );
        formateurResponse.name( formateur.getName() );
        formateurResponse.prenom( formateur.getPrenom() );
        formateurResponse.email( formateur.getEmail() );
        formateurResponse.specialite( formateur.getSpecialite() );

        return formateurResponse.build();
    }

    @Override
    public void updateEntity(Formateur entity, FormateurRequest request) {
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
        if ( request.getSpecialite() != null ) {
            entity.setSpecialite( request.getSpecialite() );
        }
    }

    private Integer formateurFormationId(Formateur formateur) {
        if ( formateur == null ) {
            return null;
        }
        Formation formation = formateur.getFormation();
        if ( formation == null ) {
            return null;
        }
        Integer id = formation.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer formateurClasseId(Formateur formateur) {
        if ( formateur == null ) {
            return null;
        }
        Classe classe = formateur.getClasse();
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
