package mx.nxtlab.micronaut.data.jdbc;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.PageableRepository;

import static io.micronaut.data.model.query.builder.sql.Dialect.POSTGRES;

@JdbcRepository(dialect = POSTGRES)
public interface PeopleRepository extends PageableRepository<Person, Long> {
}
