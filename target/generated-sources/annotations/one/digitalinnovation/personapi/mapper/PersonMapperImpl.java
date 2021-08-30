package one.digitalinnovation.personapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO.PersonDTOBuilder;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Person.PersonBuilder;
import one.digitalinnovation.personapi.entity.Phone;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T09:27:32-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        if ( dto.getBirthDate() != null ) {
            person.birthDate( LocalDate.parse( dto.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.id( dto.getId() );
        person.firstName( dto.getFirstName() );
        person.lastName( dto.getLastName() );
        person.cpf( dto.getCpf() );
        List<Phone> list = dto.getFones();
        if ( list != null ) {
            person.fones( new ArrayList<Phone>( list ) );
        }

        return person.build();
    }

    @Override
    public PersonDTO toDTO(Person dto) {
        if ( dto == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.id( dto.getId() );
        personDTO.firstName( dto.getFirstName() );
        personDTO.lastName( dto.getLastName() );
        personDTO.cpf( dto.getCpf() );
        if ( dto.getBirthDate() != null ) {
            personDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getBirthDate() ) );
        }
        List<Phone> list = dto.getFones();
        if ( list != null ) {
            personDTO.fones( new ArrayList<Phone>( list ) );
        }

        return personDTO.build();
    }
}
