package metrics.demo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller("/nxtlab")
public class Endpoint {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    private Hasher hasher;

    @Get("/hash/{string}")
    public String hash(String string){
        String result = hasher.hash(string);
        if(result == null) {
            throw new RuntimeException("Can't hash!");
        }
        log.debug("hash '{}' => {}", string, result);
        return result;
    }
}
