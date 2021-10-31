package one.digitalinnovation.crudDIO.repository;

import one.digitalinnovation.crudDIO.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
