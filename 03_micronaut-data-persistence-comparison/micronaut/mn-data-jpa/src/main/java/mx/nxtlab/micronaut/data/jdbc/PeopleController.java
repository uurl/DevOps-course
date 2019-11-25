package mx.nxtlab.micronaut.data.jdbc;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;

import static io.micronaut.http.HttpStatus.CREATED;

@Controller("/v1/people")
public class PeopleController {
  private final PeopleService peopleService;

  public PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @Post
  @Status(CREATED)
  public Person create(@Body Person person) {
    return peopleService.create(person);
  }
}
