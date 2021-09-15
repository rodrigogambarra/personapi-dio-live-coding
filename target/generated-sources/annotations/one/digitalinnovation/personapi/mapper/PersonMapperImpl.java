package one.digitalinnovation.personapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.PhoneDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-06T21:41:36-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Person person = new Person();

        if ( dto.getBirthDate() != null ) {
            person.setBirthDate( LocalDate.parse( dto.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.setId( dto.getId() );
        person.setFirstName( dto.getFirstName() );
        person.setLastName( dto.getLastName() );
        person.setCpf( dto.getCpf() );
        person.setFones( phoneDTOListToPhoneList( dto.getFones() ) );

        return person;
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
        personDTO.setFones( phoneListToPhoneDTOList( dto.getFones() ) );

        return personDTO;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setNumber( phoneDTO.getNumber() );

        return phone;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setNumber( phone.getNumber() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
