package mx.nxtlab.micronaut.data.springboot.jdbc;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/people")
public class PeopleController {

  private final PeopleService peopleService;

  public PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public Person create(@RequestBody Person person) {
    return peopleService.create(person);
  }
}
