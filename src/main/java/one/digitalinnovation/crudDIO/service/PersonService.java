package one.digitalinnovation.crudDIO.service;

import one.digitalinnovation.crudDIO.dto.response.MessageResponseDTO;
import one.digitalinnovation.crudDIO.entity.Person;
import one.digitalinnovation.crudDIO.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person witd ID " + savedPerson.getId()).build();
    }
}
