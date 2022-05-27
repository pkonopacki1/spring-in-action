package com.konopackipio1.tacocloud.data;

import java.util.Optional;

import com.konopackipio1.tacocloud.model.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
