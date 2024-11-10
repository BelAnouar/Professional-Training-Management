package com.formation.formation.mapper;

import com.formation.formation.Entity.Classe;
import com.formation.formation.dto.request.ClasseRequest;
import com.formation.formation.dto.response.ClasseResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-09T00:46:34+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ClasseMapperImpl implements ClasseMapper {

    @Override
    public Classe toEntity(ClasseRequest request) {
        if ( request == null ) {
            return null;
        }

        Classe.ClasseBuilder classe = Classe.builder();

        classe.name( request.getName() );
        classe.roomNumber( request.getRoomNumber() );

        return classe.build();
    }

    @Override
    public ClasseResponse toResponse(Classe classroom) {
        if ( classroom == null ) {
            return null;
        }

        ClasseResponse.ClasseResponseBuilder classeResponse = ClasseResponse.builder();

        classeResponse.id( classroom.getId() );
        classeResponse.name( classroom.getName() );
        classeResponse.roomNumber( classroom.getRoomNumber() );

        return classeResponse.build();
    }

    @Override
    public void updateEntity(Classe entity, ClasseRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            entity.setName( request.getName() );
        }
        if ( request.getRoomNumber() != null ) {
            entity.setRoomNumber( request.getRoomNumber() );
        }
    }
}
