package mx.nxtlab.micronaut.data.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
}
