package com.konopackipio1.tacocloud.data;

import java.util.List;

import com.konopackipio1.tacocloud.model.TacoOrder;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

}
