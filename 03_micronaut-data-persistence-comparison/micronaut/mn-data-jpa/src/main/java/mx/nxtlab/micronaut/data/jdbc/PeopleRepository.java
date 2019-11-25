package mx.nxtlab.micronaut.data.jdbc;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface PeopleRepository extends PageableRepository<Person, Long> {
}
