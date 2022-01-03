package org.acme.hibernate.orm.panache;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/extensions")
@RegisterRestClient
public interface ExtensionsService {

  @GET
  Set<Extension> getById(@QueryParam("id") String id);

  @GET
  CompletionStage<Set<Extension>> getByIdAsync(@QueryParam("id") String id);
}
