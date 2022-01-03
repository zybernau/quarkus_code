package org.acme.hibernate.orm.panache;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.acme.rest.user.PagedUsers;
import org.acme.rest.user.User;
import org.acme.rest.user.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import io.quarkus.panache.common.Sort;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import io.smallrye.mutiny.infrastructure.Infrastructure;

@Path("/fruitImages")
@ApplicationScoped
public class FruitImageResource {

  @RestClient
  UserService userService;

  @GET
  @Path("/")
  @Blocking
  public Uni<List<FruitImage>> getFruitImage() {
    Uni<List<Fruit>> fruits = Fruit.listAll(Sort.by("id"));
    List<FruitImage> newList = new ArrayList<FruitImage>();
    // Duration duration = Duration.ofSeconds(3);


    return fruits.map(fruitList -> {
      for (Fruit fruit : fruitList) {
        FruitImage fi = new FruitImage();
        fi.setName(fruit.name);
        // fi.setImageUrl(getImageUrl(fruit.id).emitOn(Infrastructure.getDefaultExecutor()).subscribe());
        getImageUrl(fruit.id).runSubscriptionOn(Infrastructure.getDefaultWorkerPool()).subscribe()
              .with(record -> {
                fi.setImageUrl(record);
                System.out.println(record);
              });
        // fi.setImageUrl(getImageUrl(fruit.id).await().atMost(duration));

        // .subscribe()
        // .with(record -> fi.setImageUrl(record));
        newList.add(fi);
      }
      return newList;
    });

  }

  // public Uni<String> getImageUrl(Long id) {
  //   Uni<PagedUsers> users = userService.getUser(id);
  //   return users.map(userList -> {
  //     String theUrl = "";
  //     for (User user : userList.getData()) {
  //       if (user.getId() == id) {
  //         theUrl = user.getAvatar();
  //       }
  //     }
  //     return theUrl;
  //   });
  // }

  public Uni<String> getImageUrl(Long id) {
    Duration duration = Duration.ofSeconds(3);

    Uni<PagedUsers> users = userService.getUser(id);
    return users.map(userList -> {
      String theUrl = "";
      for (User user : userList.getData()) {
        if (user.getId() == id) {
          theUrl = user.getAvatar();
        }
      }
      return theUrl;
    })
    // .emitOn(Infrastructure.getDefaultWorkerPool())
    // .runSubscriptionOn(Infrastructure.getDefaultExecutor())
    // .await().atMost(duration)
    ;
  }
}
