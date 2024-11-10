package com.formation.formation.mapper;

import com.formation.formation.Entity.Apprenant;
import com.formation.formation.Entity.Formation;
import com.formation.formation.dto.request.FormationRequest;
import com.formation.formation.dto.response.ApprenantResponse;
import com.formation.formation.dto.response.FormationResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-09T00:46:34+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FormationMapperImpl implements FormationMapper {

    @Override
    public Formation toEntity(FormationRequest formationRequest) {
        if ( formationRequest == null ) {
            return null;
        }

        Formation.FormationBuilder formation = Formation.builder();

        formation.titre( formationRequest.getTitre() );
        formation.niveau( formationRequest.getNiveau() );
        formation.prerequis( formationRequest.getPrerequis() );
        formation.capaciteMin( formationRequest.getCapaciteMin() );
        formation.capaciteMax( formationRequest.getCapaciteMax() );
        formation.dateDebut( formationRequest.getDateDebut() );
        formation.dateFin( formationRequest.getDateFin() );
        formation.statut( formationRequest.getStatut() );

        return formation.build();
    }

    @Override
    public FormationResponse toResponse(Formation formation) {
        if ( formation == null ) {
            return null;
        }

        FormationResponse.FormationResponseBuilder formationResponse = FormationResponse.builder();

        formationResponse.id( formation.getId() );
        formationResponse.titre( formation.getTitre() );
        formationResponse.niveau( formation.getNiveau() );
        formationResponse.prerequis( formation.getPrerequis() );
        formationResponse.capaciteMin( formation.getCapaciteMin() );
        formationResponse.capaciteMax( formation.getCapaciteMax() );
        formationResponse.dateDebut( formation.getDateDebut() );
        formationResponse.dateFin( formation.getDateFin() );
        formationResponse.apprenants( apprenantListToApprenantResponseList( formation.getApprenants() ) );
        formationResponse.statut( formation.getStatut() );

        return formationResponse.build();
    }

    @Override
    public void updateEntity(Formation entity, FormationRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getTitre() != null ) {
            entity.setTitre( request.getTitre() );
        }
        if ( request.getNiveau() != null ) {
            entity.setNiveau( request.getNiveau() );
        }
        if ( request.getPrerequis() != null ) {
            entity.setPrerequis( request.getPrerequis() );
        }
        if ( request.getCapaciteMin() != null ) {
            entity.setCapaciteMin( request.getCapaciteMin() );
        }
        if ( request.getCapaciteMax() != null ) {
            entity.setCapaciteMax( request.getCapaciteMax() );
        }
        if ( request.getDateDebut() != null ) {
            entity.setDateDebut( request.getDateDebut() );
        }
        if ( request.getDateFin() != null ) {
            entity.setDateFin( request.getDateFin() );
        }
        if ( request.getStatut() != null ) {
            entity.setStatut( request.getStatut() );
        }
    }

    protected ApprenantResponse apprenantToApprenantResponse(Apprenant apprenant) {
        if ( apprenant == null ) {
            return null;
        }

        ApprenantResponse.ApprenantResponseBuilder apprenantResponse = ApprenantResponse.builder();

        apprenantResponse.id( apprenant.getId() );
        apprenantResponse.name( apprenant.getName() );
        apprenantResponse.prenom( apprenant.getPrenom() );
        apprenantResponse.email( apprenant.getEmail() );
        apprenantResponse.niveau( apprenant.getNiveau() );

        return apprenantResponse.build();
    }

    protected List<ApprenantResponse> apprenantListToApprenantResponseList(List<Apprenant> list) {
        if ( list == null ) {
            return null;
        }

        List<ApprenantResponse> list1 = new ArrayList<ApprenantResponse>( list.size() );
        for ( Apprenant apprenant : list ) {
            list1.add( apprenantToApprenantResponse( apprenant ) );
        }

        return list1;
    }
}
