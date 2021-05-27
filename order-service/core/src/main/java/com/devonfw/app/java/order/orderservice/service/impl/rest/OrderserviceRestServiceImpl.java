package com.devonfw.app.java.order.orderservice.service.impl.rest;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

/**
 * TODO FLOFFLER This type ...
 *
 */
@Named("OrderserviceRestService")
public class OrderserviceRestServiceImpl implements OrderserviceRestService {

  @Inject
  private Orderservice orderservice;

  @Override
  public Set<ItemEto> findItemByName(String name) {

    return this.orderservice.findByName(name);
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    return this.orderservice.saveItem(item);
  }

  @Override
  public void deleteItem(Long id) {

    return this.orderservice.deleteItem(id);

  }

  @Override
  public void updateItem(ItemEto item, String name) {

    // TODO Auto-generated method stub

  }

  @Override
  public Set<ItemEto> findItems() {

    return null;
  }

}
