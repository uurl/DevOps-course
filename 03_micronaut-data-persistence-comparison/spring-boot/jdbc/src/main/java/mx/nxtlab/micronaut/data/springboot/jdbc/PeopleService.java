package mx.nxtlab.micronaut.data.springboot.jdbc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeopleService {

  private final PeopleRepository peopleRepository;

  public PeopleService(PeopleRepository peopleRepository) {
    this.peopleRepository = peopleRepository;
  }

  public Person create(Person person) {
    peopleRepository.save(person);
    return person;
  }
}
