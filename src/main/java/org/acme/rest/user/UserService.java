package org.acme.rest.user;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

@Path("/users")
@RegisterRestClient
public interface UserService {
  @GET
  Uni<PagedUsers> getUser(@QueryParam("page") Long page);
}





