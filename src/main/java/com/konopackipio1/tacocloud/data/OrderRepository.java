package com.konopackipio1.tacocloud.data;

import com.konopackipio1.tacocloud.model.TacoOrder;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
