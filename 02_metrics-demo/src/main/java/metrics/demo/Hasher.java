package metrics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

public class Hasher {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final long start = System.currentTimeMillis();

    private final static Random rng = new Random();

    public String hash(String something) {
        if (rng.nextInt() % 20 == 0 && System.currentTimeMillis() - start > 2000) {
            throw new RuntimeException("Boom!");
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            md5.update(something.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(md5.digest());
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
            log.error("No pude generar el hash para {}", something, ex);
            return null;
        }

    }
}
