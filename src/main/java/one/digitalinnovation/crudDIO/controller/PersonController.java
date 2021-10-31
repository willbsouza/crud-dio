package one.digitalinnovation.crudDIO.controller;

import one.digitalinnovation.crudDIO.dto.response.MessageResponseDTO;
import one.digitalinnovation.crudDIO.entity.Person;
import one.digitalinnovation.crudDIO.repository.PersonRepository;
import one.digitalinnovation.crudDIO.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

}
