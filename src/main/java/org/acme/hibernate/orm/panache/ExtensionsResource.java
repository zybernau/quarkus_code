package org.acme.hibernate.orm.panache;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;

@Path("/extension")
public class ExtensionsResource {

  @RestClient
  ExtensionsService extensionService;

  @GET
  @Path("/id/{id}")
  @Blocking
  public Set<Extension> id(String id) {
    System.out.println(id);
    return extensionService.getById(id);
  }

  @GET
  @Path("/as-id/{id}")
  @NonBlocking
  public CompletionStage<Set<Extension>> asId(String id) {
    return extensionService.getByIdAsync(id);
  }
}
