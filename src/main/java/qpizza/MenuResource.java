package qpizza;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuResource {

  @GET
  public Menu getMenu() {
    var menu = new Menu() {
      {
        title = "Olá QPizzas";
      }
    };

    return menu;
  }
}
