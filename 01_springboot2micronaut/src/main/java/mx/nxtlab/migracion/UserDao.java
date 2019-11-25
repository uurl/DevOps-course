package mx.nxtlab.migracion;

import mx.nxtlab.migracion.vo.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

@ManagedBean
public class UserDao {
    @Inject
    private JdbcTemplate jdbc;

    public Optional<User> getUser(long userId) {
        try {
            return Optional.of(jdbc.queryForObject(
                    "SELECT * FROM demo_user WHERE userd_id=" + userId, User.class
            ));
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public boolean updateLastSeen(User u) {
        Date now = new Date();
        int r = jdbc.update("UPDATE demo_user SET last_seen=" + now );
        if(r>0){
            u.setLastSeen(now);
        }
        return r>0;
    }

    public boolean updatePassword(User u) {
        int r = jdbc.update("UPDATE demo_user SET password=" + u.getPassword() );
        if(r>0){
            u.setPassword(u.getPassword());
        }
        return r>0;
    }

}
