package mx.nxtlab.micronaut.data.springboot.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PeopleRepository {
  private final JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public PeopleRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  public int count() {
    return jdbcTemplate
      .queryForObject("select count(*) from people", Integer.class);
  }

  public int save(Person person) {
    return jdbcTemplate.update(
      "insert into people (first_name, last_name) values(?,?)",
      person.getFirstName(), person.getLastName());
  }

  public int update(Person person) {
    return namedParameterJdbcTemplate.update(
      "update people set email = :email, first_name = :firstName, last_name = :lastName where username = :username",
      new BeanPropertySqlParameterSource(person));
  }

  public int deleteById(String username) {
    return jdbcTemplate.update(
      "delete people where username = ?",
      username);
  }

  public Optional<Person> findById(String username) {
    return namedParameterJdbcTemplate.queryForObject(
      "select * from people where username = :username",
      new MapSqlParameterSource("username", username),
      (rs, rowNum) ->
        Optional.of(from(rs))
    );
  }

  private Person from(ResultSet rs) {
    try {
      return Person.builder()
        .id(rs.getLong("id"))
        .firstName(rs.getString("first_name"))
        .lastName(rs.getString("last_name"))
        .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Person> findByNameAndPrice(String name, BigDecimal price) {

    MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
    mapSqlParameterSource.addValue("name", "%" + name + "%");
    mapSqlParameterSource.addValue("price", price);

    return namedParameterJdbcTemplate.query(
      "select * from people where name like :name and price <= :price",
      mapSqlParameterSource,
      (rs, rowNum) -> from(rs)
    );
  }

}
