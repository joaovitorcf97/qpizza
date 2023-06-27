package qpizza;

import java.util.List;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("ingredient")
public class IngredientResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Ingredient> ListAll() {
        List<Ingredient> result = Ingredient.listAll();

        return result;
    }

    @Transactional
    public void init(@Observes StartupEvent event) {
        var i = new Ingredient("Cheese");
        i.persist();
    }

}
