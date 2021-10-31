package one.digitalinnovation.crudDIO.service;

import one.digitalinnovation.crudDIO.dto.request.PersonDTO;
import one.digitalinnovation.crudDIO.dto.response.MessageResponseDTO;
import one.digitalinnovation.crudDIO.entity.Person;
import one.digitalinnovation.crudDIO.exception.PersonNotFoundException;
import one.digitalinnovation.crudDIO.mapper.PersonMapper;
import one.digitalinnovation.crudDIO.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
    }

    public List<PersonDTO> listAll() {
       List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public void delele(Long id) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        Person personToUpdate = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToUpdate);
        return MessageResponseDTO.builder().message("Updated person with ID " + savedPerson.getId()).build();
    }
}
