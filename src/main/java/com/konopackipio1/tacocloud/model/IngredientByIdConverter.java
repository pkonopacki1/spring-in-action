package com.konopackipio1.tacocloud.model;

import com.konopackipio1.tacocloud.data.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// This class is used to convert text input to objects
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

        private final IngredientRepository ingredientRepository;

        @Autowired
        public IngredientByIdConverter(IngredientRepository ingredientRepository) {
                this.ingredientRepository = ingredientRepository;
        }

        @Override
        public Ingredient convert(String id) {
                return ingredientRepository.findById(id).orElse(null);
        }

}
