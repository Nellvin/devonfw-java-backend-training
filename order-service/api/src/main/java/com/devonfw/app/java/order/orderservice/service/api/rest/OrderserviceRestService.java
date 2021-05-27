package com.devonfw.app.java.order.orderservice.service.api.rest;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.module.rest.common.api.RestService;

/**
 * TODO FLOFFLER This type ...
 *
 */
@Path("/orderservice/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OrderserviceRestService extends RestService {

  @GET
  @Path("/items/")
  public Set<ItemEto> findItems();

  @GET
  @Path("/items/{name}")
  public Set<ItemEto> findItemByName(@PathParam("name") String name);

  @PUT
  @Path("/items/")
  public ItemEto saveItem(ItemEto item);

  @DELETE
  @Path("items/{id}")
  public boolean deleteItem(@PathParam("id") Long id);

  @POST
  @Path("items/{name}")
  public void updateItem(ItemEto item, @PathParam("name") String name);
}
