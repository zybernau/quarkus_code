package org.acme.rest.user;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;

@Path("/user")
public class UserResource {

  @RestClient
  UserService userService;

  @GET
  @Path("/users")
  public Uni<PagedUsers> getUsers(@QueryParam("page") Long page) {
    System.out.println("request came  here" + String.valueOf(page));
    return userService.getUser(page);
  }
}
