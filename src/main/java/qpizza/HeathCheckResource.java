package qpizza;

import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/health")
@Produces(MediaType.APPLICATION_JSON)
public class HeathCheckResource {

    @Inject
    DataSource ds;

    @Inject
    EntityManager em;

    @GET
    public Map<String, String> get() throws SQLException {
        var status = isDBhealth();
        var emOpen = isEMOpen().toString();
        var result = Map.of(
                "health", status,
                "emOpen", emOpen);

        return result;
    }

    private Boolean isEMOpen() {
        return em.isOpen();
    }

    private String isDBhealth() throws SQLException {
        var status = "ok";
        try (var conn = ds.getConnection()) {
            if (conn.isValid(15)) {
                status = "valid";
            } else {
                status = "invalid";
            }
        }

        return status;
    }
}
