package mx.nxtlab.micronaut.data.jdbc;

import javax.inject.Singleton;

@Singleton
public class PeopleService {
  private final PeopleRepository peopleRepository;

  public PeopleService(PeopleRepository peopleRepository) {
    this.peopleRepository = peopleRepository;
  }

  public Person create(Person person) {
    return peopleRepository.save(person);
  }
}
