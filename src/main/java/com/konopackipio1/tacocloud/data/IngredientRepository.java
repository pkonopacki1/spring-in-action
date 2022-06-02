package com.konopackipio1.tacocloud.data;

import com.konopackipio1.tacocloud.model.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
