package one.digitalinnovation.personapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Person.PersonBuilder;
import one.digitalinnovation.personapi.entity.Phone;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T08:48:30-0300",
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

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( dto.getId() );
        personDTO.setFirstName( dto.getFirstName() );
        personDTO.setLastName( dto.getLastName() );
        personDTO.setCpf( dto.getCpf() );
        if ( dto.getBirthDate() != null ) {
            personDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getBirthDate() ) );
        }
        List<Phone> list = dto.getFones();
        if ( list != null ) {
            personDTO.setFones( new ArrayList<Phone>( list ) );
        }

        return personDTO;
    }
}
