package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;
import com.devonfw.module.basic.common.api.query.StringSearchOperator;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ItemRepositoryTest extends ComponentTest {
  @Inject
  private ItemRepository itemRepository;

  @Override
  protected void doTearDown() {

    super.doTearDown();
    this.itemRepository.deleteAll();
  }

  @Test
  public void shouldFindAllItems() {

    // when
    prepareItems();
    List<ItemEntity> foundItems = this.itemRepository.findAll();

    // then
    assertThat(foundItems).hasSize(4);
  }

  /**
   *
   */
  @Test
  public void findFrog() {

    prepareItems();
    ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
    criteria.setName("FROG");
    StringSearchOperator syntax = StringSearchOperator.LIKE;
    StringSearchConfigTo nameOption = StringSearchConfigTo.of(syntax);
    nameOption.setIgnoreCase(true);
    nameOption.setMatchSubstring(true);
    criteria.setNameOption(nameOption);
    Sort sort = Sort.by("name");
    Pageable pageable = PageRequest.of(0, 20, sort);
    criteria.setPageable(pageable);
    Page<ItemEntity> foundItems = this.itemRepository.findByCriteria(criteria);

    // then
    assertThat(foundItems).hasSize(2);
    assertThat(foundItems).extracting("name").containsExactly("dog", "frog");
    // SELECT * FROM User Where firstName = „John“ OR lastName=„Doe“​
  }

  private void prepareItems() {

    ItemEntity item1 = new ItemEntity();
    String item1Name = "frog";
    item1.setName(item1Name);
    item1.setPrice(12.50);

    ItemEntity item2 = new ItemEntity();
    String item2Name = "dog";
    item2.setName(item2Name);
    item2.setPrice(5.50);

    ItemEntity item3 = new ItemEntity();
    String item3Name = "cat";
    item3.setName(item3Name);
    item3.setPrice(12.50);
    this.itemRepository.saveAll(Arrays.asList(item1, item2, item3));
  }

}