package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSaved = personMapper.toModel(personDTO);

        Person personSaved = personRepository.save(personToSaved);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + personSaved.getId())
                .build();
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
