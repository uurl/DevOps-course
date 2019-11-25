package mx.nxtlab.micronaut.data.springboot.jpa;

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

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@Slf4j
@Entity
@Table(name = "people")
public class Person {
  public final static String NAME = "Person";

  @Id
  @GeneratedValue(strategy = IDENTITY)
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
