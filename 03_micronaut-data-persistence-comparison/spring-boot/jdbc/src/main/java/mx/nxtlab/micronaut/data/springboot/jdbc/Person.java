package mx.nxtlab.micronaut.data.springboot.jdbc;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@Slf4j
public class Person {
  public final static String NAME = "Person";

  @NotBlank
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
