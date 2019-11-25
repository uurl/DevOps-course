package mx.nxtlab.micronaut.data.jdbc;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@Slf4j
@Entity
@Table(name = "people")
@Introspected
public class Person {
  public final static String NAME = "Person";

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;

  @Tolerate
  public Person() {
    log.debug("Creating {}", NAME);
  }
}
