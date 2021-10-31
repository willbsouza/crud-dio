package one.digitalinnovation.crudDIO.service;

import one.digitalinnovation.crudDIO.dto.request.PersonDTO;
import one.digitalinnovation.crudDIO.dto.response.MessageResponseDTO;
import one.digitalinnovation.crudDIO.entity.Person;
import one.digitalinnovation.crudDIO.mapper.PersonMapper;
import one.digitalinnovation.crudDIO.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person witd ID " + savedPerson.getId()).build();
    }
}
